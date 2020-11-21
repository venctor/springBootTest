package com.springboot.controller;

import com.springboot.bean.Book;
import com.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guangxi.dong01@hand-china.com
 * @description test controller
 * @date 2020/11/18
 */
@RestController
public class TestController {
    @Autowired
    private Book book;
    @Autowired
    private Person person;
    /***
     * @Description: 获取配置文件的参数
     * @param :
     * @return java.lang.String
     * @author guangxi.dong01@hand-china.com
     * @date 2020/11/19 15:14
     */
    @RequestMapping("/getBook")
    String getBookProperties() {
        return book.getName()+"——"+book.getTitle()+"888888888888888";
    }
    /***
     * @Description: 读取不同环境的person对象
     *通过修改 maven-profiles-不同环境，生成不同环境的配置文件
     * @param :
     * @return java.lang.String
     * @author guangxi.dong01@hand-china.com
     * @date 2020/11/18 17:16
     */
    @RequestMapping("/getPerson")
    String getPerson(){
        return person.getName()+":"+person.getAge();
    }
}
