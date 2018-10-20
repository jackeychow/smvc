package com.zhj.smvc.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhj.smvc.entity.Permission;
import com.zhj.smvc.mapper.PermissionMapper;
import com.zhj.smvc.service.IPermissionService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jc
 * @since 2018-10-10
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
	
}
