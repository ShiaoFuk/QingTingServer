package com.example.qingtingserver.utils;

import com.example.qingtingserver.model.User;

/**
 * 检查用户的账号密码是否合法，主要用于注册的时候验证
 */
public class UserValidCheckUtils {

    /**
     * 账号密码均需要满足至少6位，至多20位，密码需要同时包含数字和字母
     * @param user
     * @return
     */
    public static boolean checkUser(User user) {
        return checkPassword(user.getPassword()) && checkUserName(user.getUsername());
    }


    private static boolean checkUserName(String username) {
        int userNameLength = username.length();
        return userNameLength <= 20 && userNameLength >= 6;
    }

    private static boolean checkPassword(String password) {
        int passwordLength = password.length();
        return passwordLength <= 20 && passwordLength >= 6 && password.matches(".*[a-zA-Z].*") && password.matches(".*\\d.*");
    }
}
