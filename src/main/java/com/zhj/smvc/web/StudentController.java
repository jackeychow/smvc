package com.zhj.smvc.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhj.smvc.ConsoleResult;
import com.zhj.smvc.entity.Student;
import com.zhj.smvc.service.AsyncTest;
import com.zhj.smvc.service.IStudentService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Jc
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private AsyncTest       asyncTest;

    @RequestMapping("/getstudent")
    @RequiresRoles("admin")
    public Student getStudentById(Integer id) {
        return studentService.selectById(id);
    }

    @RequestMapping("/delstudent")
    public Object delStudentById(Integer id) {
        return studentService.deleteById(id);
    }

    @RequestMapping("/selectpage")
    @RequiresRoles("system")
    public List<Student> selectPage(Integer pagenum, Integer pagesize) {
        Page<Student> page = new Page<>(pagenum , pagesize);
        page = studentService.selectPage(page);
//        Integer count = page.getTotal();
//        System.out.println(count);
        return page.getRecords();
    }

    @RequestMapping("/selectfemalelist")
    public List<Student> selectFemaleList(String sex) {
        Wrapper<Student> wrapper = new EntityWrapper<Student>();
        wrapper.eq(Student.SEX, sex);
        wrapper.orderBy(Student.ID, false);
        List<Student> list = studentService.selectList(wrapper);
        return list;
    }

    @RequestMapping("/loginAction")
    public String loginAction(String username) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, "");
        try {
            subject.login(token);
            return "login success";
        } catch (Exception e) {
            return "login Failed!";
        }
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("Main Thread id:" + Thread.currentThread().getId());
        asyncTest.asyncOut();
        return "login page";
    }
    
    /**
     * 分页查询
     * 
     * @param pagenum 第几页
     * @param pagesize 每页数据个数
     * @return List<Student>
     */
    @RequestMapping("/selectstudentpage")
    public ConsoleResult<List<Student>> selectStudentPageList(Integer pagenum, Integer pagesize) {
        return ConsoleResult.success(studentService.selectStudentPage(pagenum, pagesize));
    }

}
