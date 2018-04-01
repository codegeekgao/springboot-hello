package com.donniegao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springBoot入门程序
 *
 * @author gaoxinpeng
 * @version Id: Application.java, v 0.1 2018/3/28 上午9:31 gaoxinpeng Exp $$
 */
@SpringBootApplication
@RestController
public class Application {

    /**
     * say hello
     *
     * @return 返回结果
     */
    @RequestMapping("/")
    public String sayHello() {
        return "hello, SpringBoot !";
    }

    public static void main(String[] args) {
        // 运行SpringBoot
        SpringApplication.run(Application.class,args);
    }
}
