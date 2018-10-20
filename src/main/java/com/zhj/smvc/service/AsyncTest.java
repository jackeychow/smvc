/** 
 * Filename AsyncTest.java
 * Create on 2018年10月10日
 * Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Description: 
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Component
public class AsyncTest {

    @Async
    public void asyncOut() {
        System.out.println("异步方法id：" + Thread.currentThread().getId());
    }
}
