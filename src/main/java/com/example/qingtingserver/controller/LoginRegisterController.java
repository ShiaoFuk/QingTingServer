package com.example.qingtingserver.controller;

import com.example.qingtingserver.model.User;
import com.example.qingtingserver.model.Result;
import com.example.qingtingserver.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegisterController {

    private final LoginRegisterService loginRegisterService;

    @Autowired
    public LoginRegisterController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }

    /**
     * 登录接口
     * @param loginUser 登录信息，需要填写username和password，password是经过aes加密的
     * @return 返回的token
     */
    @PostMapping("/login")
    public Result login(@RequestBody User loginUser) {
        String token = loginRegisterService.login(loginUser);
        if (token != null) {
            return Result.success(token);
        }
        return Result.error("login failed");
    }


    /**
     * 注册接口
     * @param registerUser 注册信息，需要填写username和password，password是经过aes加密的
     * @return 返回的token
     */
    @PostMapping("/register")
    public Result register(@RequestBody User registerUser) {
        String token = loginRegisterService.register(registerUser);
        if (token != null) {
            return Result.success(token);
        }
        return Result.error("register failed");
    }
}
