package top.javinjunfeng.springbootweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: javinjunfeng
 * @Date: 2019/1/19 9:13 AM
 * @Version 1.0
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello  " + name;
    }
}
