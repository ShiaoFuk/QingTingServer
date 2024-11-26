package com.example.qingtingserver.service;

import com.example.qingtingserver.model.PlayList;
import com.example.qingtingserver.model.User;
import com.example.qingtingserver.repository.LoginRegisterRepository;
import com.example.qingtingserver.repository.PlayListRepository;
import com.example.qingtingserver.utils.AESCyperUtils;
import com.example.qingtingserver.utils.Argon2PasswordHasher;
import com.example.qingtingserver.utils.JwtUtil;
import com.example.qingtingserver.utils.UserValidCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginRegisterService {
    private final LoginRegisterRepository loginRegisterRepository;

    AESCyperUtils aesCyperUtils;
    Argon2PasswordHasher argon2PasswordHasher;
    JwtUtil jwtUtil;
    PlayListRepository playListRepository;
    @Autowired
    public LoginRegisterService(LoginRegisterRepository loginRegisterRepository, AESCyperUtils aesCyperUtils, JwtUtil jwtUtil, Argon2PasswordHasher argon2PasswordHasher, PlayListRepository playListRepository) {
        this.loginRegisterRepository = loginRegisterRepository;
        this.aesCyperUtils = aesCyperUtils;
        this.jwtUtil = jwtUtil;
        this.argon2PasswordHasher = argon2PasswordHasher;
        this.playListRepository = playListRepository;
    }

    // 对密码解密

    /**
     * 注册，先对密码解密，再哈希存储
     * @param user 要注册用户
     */
    @Transactional
    public String register(User user) {
//        decodeUser(user);
        // 检查是否合理
        if (!UserValidCheckUtils.checkUser(user)) return null;
        hashUser(user);
        Integer userId = loginRegisterRepository.register(user);
        if (userId == null) { return null; }
        // 注册时候自动生成"我喜欢"歌单
        PlayList playList = new PlayList();
        playList.setUserId(userId);
        playListRepository.addPlayList(playList);
        return jwtUtil.generateToken(userId);
    }


    public String login(User user) {
        //        decodeUser(user);
        User user1 = loginRegisterRepository.login(user);
        if (user1 == null) { return null; }
        if (!argon2PasswordHasher.verifyPassword(user1.getPassword(), user.getPassword())) {
            return null;
        }
        return jwtUtil.generateToken(user1.getId());
    }


    // 将密码根据AES解密得到密码原文
    private void decodeUser(User user) {
        try {
            String decodePassword;
            decodePassword = aesCyperUtils.decrypt(user.getPassword());
            user.setPassword(decodePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 将密码进行哈希
    private void hashUser(User user) {
        String encodedPassword = argon2PasswordHasher.hashPassword(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
