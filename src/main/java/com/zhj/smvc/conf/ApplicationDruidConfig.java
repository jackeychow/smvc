/**
 * Filename ApplicationDruidConfig.java Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc.conf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import lombok.extern.log4j.Log4j;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @date Create on 2018年10月18日 下午4:20:18
 * @since version1.0
 */

//说明这是一个配置文件
//@Configuration
@Log4j
public class ApplicationDruidConfig {

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    // 因为SpringBoot也为我们提供了一个默认的datasource，可谓贴心，当我们需要自己的连接池的时候，可以使用@primary注解，告诉Springboot
    // 优先使用我们自己的DataSource
    public DataSource dataSource() {
        log.info("init sbmvd ApplicationDruidConfig datasource...");
        return new DruidDataSource();
    }

    /**
     * 配置druid监控 配置一个管理后台的servlet 访问地址：http://localhost:8080/druid/
     * 
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        log.info("init ApplicationDruidConfig ServletRegistrationBean...");
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        // 控制台管理用户
        initParameters.put("loginUsername", "admin");// 属性见：com.alibaba.druid.support.http.ResourceServlet
        initParameters.put("loginPassword", "123456");
        // IP白名单
        initParameters.put("allow", "*");// 默认允许所有
        // IP黑名单(共同存在时，deny优先于allow)
        initParameters.put("deny", "92.168.1.19");
        // 是否能够重置数据 禁用HTML页面上的“Reset All”功能
        initParameters.put("resetEnable", "false");
        bean.setInitParameters(initParameters);
        return bean;
    }

    /**
     * 配置一个web监控的filter
     * 
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        log.info("init ApplicationDruidConfig FilterRegistrationBean...");
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new WebStatFilter());
        filterBean.setUrlPatterns(Arrays.asList("/*"));

        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("exclusions", "*.js,*.css,/druid/*");// 属性见：com.alibaba.druid.support.http.WebStatFilter
        filterBean.setInitParameters(initParameters);

        return filterBean;
    }

}
