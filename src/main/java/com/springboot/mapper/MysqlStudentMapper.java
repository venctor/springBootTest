package com.springboot.mapper;

import com.springboot.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author guangxi.dong01@hand-china.com
 * @Description:
 * @date 2020/11/20 11:25
 */
@Component
@Mapper
public interface MysqlStudentMapper {

    /***
     * @Description: mysql test
     * @param :
     * @return java.util.List<com.springboot.bean.Student>
     * @author guangxi.dong01@hand-china.com
     * @date 2020/11/20 11:29
     */
    List<Student> getAllStudents();
}
