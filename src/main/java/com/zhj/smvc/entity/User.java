/**
 * Filename User.java Create on 2018年10月9日 Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.entity;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
public class User {

    private Integer id;

    private String  userName;

    private String  sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", sex=" + sex + "]";
    }

}
