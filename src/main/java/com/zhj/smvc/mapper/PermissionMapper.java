package com.zhj.smvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhj.smvc.entity.Permission;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Jc
 * @since 2018-10-10
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}