package com.zhj.smvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhj.smvc.entity.Student;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Jc
 * @since 2018-10-09
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
