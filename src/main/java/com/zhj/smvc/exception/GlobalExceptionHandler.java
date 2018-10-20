/**
 * Filename GlobalExceptionHandler.java Create on 2018年10月9日 Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorCode", "404");
        map.put("errorMsg", "找不到页面了!");
        return map;
    }

}
