/**
 * Filename TestMain.java Create on 2018年10月15日 Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc;

import com.alibaba.fastjson.JSON;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
public class TestMain {

    public static void main(String[] args) {
        Student student = Student.builder().name("jackeychow").sex("男").age(35).build();
        ConsoleResult<Student> result = ConsoleResult.success(student);
        ConsoleResult<Student> result2 = ConsoleResult.fail(ConsoleResultEnum.USER_NOT_EXIST.getCode());
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(result2));
    }

    @Setter
    @Getter
    @Builder
    public static class Student {

        String  name;

        String  sex;

        Integer age;
    }
}
