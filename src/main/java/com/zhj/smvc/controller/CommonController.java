/**
 * Filename CommonController.java Create on 2018年10月9日 Copyright 2014 Jc All Rights Reserved.
 */
package com.zhj.smvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 * 
 * @author <a href="mailto:jackeychow2003@163.com">jackeychow</a>
 * @since version1.0
 */
@Controller
public class CommonController {
    
    @Value("${school}")
    private String school;
    
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "zhousihao");
        model.addAttribute("school", school);
        return "index";
    }

}
