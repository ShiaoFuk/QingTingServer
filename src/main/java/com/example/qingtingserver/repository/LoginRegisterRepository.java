package com.example.qingtingserver.repository;

import com.example.qingtingserver.dao.LoginRegisterMapper;
import com.example.qingtingserver.model.User;
import com.example.qingtingserver.utils.Argon2PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRegisterRepository {

    LoginRegisterMapper loginRegisterMapper;
    Argon2PasswordHasher argon2PasswordHasher;
    @Autowired
    public LoginRegisterRepository(LoginRegisterMapper loginRegisterMapper, Argon2PasswordHasher argon2PasswordHasher) {
        this.loginRegisterMapper = loginRegisterMapper;
        this.argon2PasswordHasher = argon2PasswordHasher;
    }


    public Integer register(User user) {
        loginRegisterMapper.registerUser(user);
        return user.getId();
    }

    public User login(User user) {
        return loginRegisterMapper.loginUser(user);
    }

}
