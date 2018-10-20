/**
 * Filename HelloController.java Create on 2018年10月9日 Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhj.smvc.entity.User;
import com.zhj.smvc.mapper.UserMapper2;
import com.zhj.smvc.service.UserService2;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
//@RestController
public class HelloController {

    @Autowired
    private UserMapper2 userMapper;
    
    @Autowired
    private UserService2 userService;

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
        return userMapper.selectUserById(id);
    }

    @PostMapping("/insert")
    public String insert(String name, String sex) {
        userMapper.insert(name, sex);
        return "success";
    }
    
    @RequestMapping("/trans")
    public String tran() {
        userService.tranfor();
        return "success";
    }
}
