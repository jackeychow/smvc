/**
 * Filename ResultCodeEnum.java Create on 2018年10月15日 Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description:ResultData的返回码
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Getter
@AllArgsConstructor
public enum ConsoleResultEnum {
    
    // 前两位代表应用，"00"代表所有应用都适用
    SUCCESS("0000", "成功"),
    PARAM_ERROR("0001", "请求参数错误"),
    EXCEPTION_ERROR("0002", "当前网络不稳定，请稍后重试"),
    SESSION_INVALID("0003", "会话超时，请重新登录"),
    USER_NOT_EXIST("0004", "当前用户不存在，请注册后登录"),
    USER_PSWD_ERROR("0005", "请输入正确密码"),
    
    // 前两位"01"代表权限系统
    INSUFFICIEN_PERMISSIONS("01001", "权限不足");

    private final String code;

    private final String msg;
    
    public static ConsoleResultEnum getByValue(String code) {
        if (null != code) {
            for (ConsoleResultEnum type : values()) {
                if (type.getCode().equals(code)) {
                    return type;
                }
            }
        }
        return null;
    }
}
