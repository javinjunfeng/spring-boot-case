package top.javinjunfeng.springboot.log4j2.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.javinjunfeng.springboot.log4j2.service.LoggerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/log")
public class ApiController {

    @Resource
    private LoggerService loggerService;


    @RequestMapping("/show")
    public Map<String,Object> shotLog(@RequestParam("name")String name, @RequestParam("age") int age){
        Map<String,Object> result = new HashMap<>();
        result.put("name",name);
        result.put("age",age);
        for(int i=0;i<100;i++) {

            loggerService.showLog();
        }
        return result;
    }

    @RequestMapping("/show2")
    public Map<String,Object> shotLog(@RequestBody String parms){
        Map<String,Object> result = new HashMap<>();
        loggerService.showLog();
        return result;
    }


}
