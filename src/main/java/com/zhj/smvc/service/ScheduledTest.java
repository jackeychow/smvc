/**
 * Filename ScheduledTest.java Create on 2018年10月10日 Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Component
@Log4j
public class ScheduledTest {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void scheduled() {
        System.out.println("提示你==》现在时间：" + dateFormat.format(new Date()));
        log.info("提示你==》现在时间：" + dateFormat.format(new Date()));
    }
}
