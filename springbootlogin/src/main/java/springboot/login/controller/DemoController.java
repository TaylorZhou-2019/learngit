package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.login.service.RedisService;

@RestController
public class DemoController {
    @Autowired
    private RedisService redisService ;


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void demoTest(){
        redisService.set("1","value22222");
        System.out.println("redis连接成功");
    }
}
