/** 
 * Filename UserRealm.java
 * Create on 2018年10月10日
 * Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc.reaml;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zhj.smvc.entity.Permission;
import com.zhj.smvc.entity.Role;
import com.zhj.smvc.entity.Student;
import com.zhj.smvc.service.IPermissionService;
import com.zhj.smvc.service.IRoleService;
import com.zhj.smvc.service.IStudentService;

/**
 * Description: 用Student做登录控制
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
public class UserRealm extends AuthorizingRealm {
    
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IPermissionService permissionService;
    
    @Autowired
    private IRoleService roleService;
    
    /**
     * 控制角色权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());
        
        // 将当前用户的角色和权限控制进来
        Student student = studentService.selectStudentByUsername(username);
        Integer roleId = student.getRoleid();
        Role role = roleService.selectById(roleId);
        
        info.addRole(role.getRolename());
        Wrapper<Permission> wrapper = new EntityWrapper<Permission>();
        wrapper.eq(Permission.ROLEID, roleId);
        List<Permission> selectList = permissionService.selectList(wrapper);
        List<String> perList= new ArrayList<String>();
        selectList.forEach(per-> {
            perList.add(per.getName());
        });
        info.addStringPermissions(perList);
        return info;
    }

    /**
     * 控制登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        AuthenticationInfo info;
        String username = (String) token.getPrincipal();
        Student student = studentService.selectStudentByUsername(username);
        if(student != null) {
            info = new SimpleAuthenticationInfo(username, "", "majiaxueyuan");
            return info;
        }
        return null;
    }

}
