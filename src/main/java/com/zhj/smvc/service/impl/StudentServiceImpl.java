package com.zhj.smvc.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhj.smvc.entity.Student;
import com.zhj.smvc.mapper.StudentMapper;
import com.zhj.smvc.service.IStudentService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Jc
 * @since 2018-10-09
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
	
    @Autowired
    private StudentMapper studentMapper;
    
    public List<Student> selectStudentPage(Integer pagenum, Integer pageSize) {
        Wrapper<Student> wrapper = new EntityWrapper<Student>();
        RowBounds rowBounds = new RowBounds((pagenum - 1) * pageSize , pageSize);
        List<Student> list = studentMapper.selectPage(rowBounds, wrapper);
        return list;
    }

    @Override
    public Student selectStudentByUsername(String username) {
        Wrapper<Student> wrapper = new EntityWrapper<Student>();
        wrapper.eq(Student.USERNAME, username);
        List<Student> stuList = studentMapper.selectList(wrapper);
        if(CollectionUtils.isNotEmpty(stuList)) {
            return stuList.get(0);
        }
        return null;
    }
}
