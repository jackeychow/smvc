/**
 * Filename ResultData.java Create on 2018年10月15日 Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description: Facade的远程接口调用和http请求的接口调用返回结果
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Setter
@Getter
@ToString
@Builder
public class ConsoleResult<T> {

    private String status;

    private T      data;

    private String msg;

    /**
     * 接口调用成功
     */
    public static <T> ConsoleResult<T> success(T data) {
        return ConsoleResult.<T> builder().status(ConsoleResultEnum.SUCCESS.getCode()).msg(ConsoleResultEnum.SUCCESS.getMsg()).data(data).build();
    }

    /**
     * 接口调用失败
     * 
     * @param code 传入的失败code值
     * @param msg 传入的失败信息
     * @return
     */
    public static <T> ConsoleResult<T> fail(String code, String msg) {
        return ConsoleResult.<T> builder().status(code).msg(msg).build();
    }

    /**
     * 当传入的code值与ResultCodeEnum中定义的枚举存在时，可以只传入code码
     * 
     * @param code 传入的失败code值
     * @return
     */
    public static <T> ConsoleResult<T> fail(String code) {
        return ConsoleResult.<T> builder().status(code).msg(ConsoleResultEnum.getByValue(code).getMsg()).build();
    }

}
