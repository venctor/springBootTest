package com.springboot.controller;

import com.springboot.bean.Student;
import com.springboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guangxi.dong01@hand-china.com
 * @description test controller
 * @date 2020/11/20
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("querystudentsfrommysql")
    public List<Student> getAllStudenets(){
        logger.info("***********************************");
        return studentService.getAllStudents();
    }


}
