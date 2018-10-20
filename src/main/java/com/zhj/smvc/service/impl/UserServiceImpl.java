/** 
 * Filename UserServiceImpl.java
 * Create on 2018年10月9日
 * Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhj.smvc.entity.User;
import com.zhj.smvc.mapper.UserMapper;
import com.zhj.smvc.service.UserService;


/**
 * Description: 
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void tranfor(String userName, Integer id) {
        User userResult = userMapper.selectById(id);
        userResult.setUserName(userName);
        userMapper.updateById(userResult);
        /*// 更新一条数据
        userMapper.update("lvqing", 17);
        // 抛出一个异常
//        int a = 2 / 0;
        // 删除一条数据
        userMapper.delete(17);*/
    }

}
