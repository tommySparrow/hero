package com.house.hero.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/3/25
 * @ Description：
 * @ throws
 */
@RestController
@RequestMapping("/login")
public class ShiroLoginController {

    @PostMapping
    public void login(String username, String password){

        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException | LockedAccountException | IncorrectCredentialsException e){
            System.out.println("登录失败");
            System.out.println(e.getMessage());
        }
        System.out.println("登录成功....");
    }
}
