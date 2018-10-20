package com.zhj.smvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j;

@SpringBootApplication
@Log4j
public class SmvcApplication {

	public static void main(String[] args) {
	    log.info("配置DruidConfig后，采用lombok的log4j，启动主程序的时候，测试日志，进来了么？ yeah");
		SpringApplication.run(SmvcApplication.class, args);
	}
}