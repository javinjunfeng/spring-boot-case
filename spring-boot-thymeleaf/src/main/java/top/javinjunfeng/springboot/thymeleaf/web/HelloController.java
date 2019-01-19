package top.javinjunfeng.springboot.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: javinjunfeng
 * @Date: 2019/1/19 6:14 PM
 * @Version 1.0
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "javinjunfeng.top");
        return "hello";
    }

}
