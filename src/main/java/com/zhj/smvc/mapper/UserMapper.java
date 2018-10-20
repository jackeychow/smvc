/**
 * Filename UserMapper.java Create on 2018年10月9日 Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhj.smvc.entity.User;
/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{
}
