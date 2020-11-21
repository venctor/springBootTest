package com.springboot.service;

import com.springboot.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author guangxi.dong01@hand-china.com
 * @Description: test
 * @date 2020/11/20 11:20
 */
public interface StudentService {

    List<Student> getAllStudents();

}
