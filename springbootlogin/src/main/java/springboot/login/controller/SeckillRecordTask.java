package springboot.login.controller;

import springboot.login.bean.User;
import springboot.login.service.LoginService;

import java.util.UUID;

public class SeckillRecordTask implements Runnable {
    private String name;
    private LoginService loginService;


    /**
     * SeckillRecordTask construct
     */
    public SeckillRecordTask(String name, LoginService loginService) {
        this.name = name;
        this.loginService = loginService;
    }

    @Override
    public void run() {
        User user = new User();
        String username = String.valueOf(UUID.randomUUID());
        user.setUsername(username);
        user.setPassword("");
        user.settypes(0);
        loginService.adduser(user);
    }
}
