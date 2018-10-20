/**
 * Filename MySrpingMVCConfig.java Create on 2018年10月13日 Copyright 2018 Jc All Rights Reserved.
 */
package com.zhj.smvc.conf;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Configuration
public class MySrpingMVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {

            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                     Object handler) throws Exception {
                System.out.println("进入preHandle");
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                   ModelAndView modelAndView) throws Exception {
                System.out.println("进入postHandle");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                        Exception ex) throws Exception {
                System.out.println("进入afterCompletion");
            }
        };
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(converter);
        super.configureMessageConverters(converters);
    }
}
