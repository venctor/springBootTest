package com;

import com.springboot.bean.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Description:
 * @author guangxi.dong01@hand-china.com
 * @date 2020/11/18 15:34
 */
@SpringBootApplication
@RestController
@EnableConfigurationProperties({Book.class})
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }

    @RequestMapping("/")
    String index(){
        return "hello ,this is springBoot2 test!";
    }


}
