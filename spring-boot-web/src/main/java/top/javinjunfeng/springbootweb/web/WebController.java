package top.javinjunfeng.springbootweb.web;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.javinjunfeng.springbootweb.model.User;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: javinjunfeng
 * @Date: 2019/1/19 9:46 AM
 * @Version 1.0
 */
@RestController
public class WebController {
    @RequestMapping(name="/getUser", method= RequestMethod.POST)
    public User getUser() {
        User user=new User();
        user.setName("小明");
        user.setAge(12);
        user.setPass("123456");
        return user;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user:"+user);
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
    }
}
