/**
 * Filename HelloController.java Create on 2018年10月9日 Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhj.smvc.entity.User;
import com.zhj.smvc.mapper.UserMapper;
import com.zhj.smvc.service.UserService;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@RestController
public class HelloController2 {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Majiaxueyuan!";
    }

    @RequestMapping("/excep")
    public String excep() {
        int a = 2 / 0;
        return "Hello Majiaxueyuan! exception";
    }

    @RequestMapping("/getuser")
    public User getUserById(Integer id) {
        User user = null;
        try {
            user = userMapper.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @PostMapping("/insert")
    public String insert(String userName, String sex) {
        User user = new User();
        user.setUserName(userName);
        user.setSex(sex);
        userMapper.insert(user);
        return "success";
    }
    
    @RequestMapping("/trans")
    public String tran(String userName, Integer id) {
        userService.tranfor(userName, id);
        return "success";
    }
}
