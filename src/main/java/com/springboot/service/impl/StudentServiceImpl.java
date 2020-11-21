package com.springboot.service.impl;

import com.springboot.bean.Student;
import com.springboot.mapper.MysqlStudentMapper;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guangxi.dong01@hand-china.com
 * @description test
 * @date 2020/11/20
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private MysqlStudentMapper mysqlStudentMapper;


    @Override
    public List<Student> getAllStudents() {
        return mysqlStudentMapper.getAllStudents();
    }
}
