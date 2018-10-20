/**
 * Filename UserMapper.java Create on 2018年10月9日 Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhj.smvc.entity.User;
/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Mapper
public interface UserMapper2 {

    @Select("select id, username as userName, sex from user where id = #{id}")
    User selectUserById(@Param("id") Integer id);

    @Insert("INSERT INTO user (`id`, `username`, `sex`) VALUES (NULL, #{userName}, #{sex});")
    int insert(@Param("userName") String userName, @Param("sex") String sex);

    @Update("UPDATE user SET username =#{userName} WHERE id = #{id}")
    int update(@Param("userName") String userName, @Param("id") Integer id);

    @Delete("DELETE from user where id = #{id}")
    void delete(@Param("id") Integer id);

}
