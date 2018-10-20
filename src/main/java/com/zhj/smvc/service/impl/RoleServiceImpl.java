package com.zhj.smvc.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhj.smvc.entity.Role;
import com.zhj.smvc.mapper.RoleMapper;
import com.zhj.smvc.service.IRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jc
 * @since 2018-10-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
