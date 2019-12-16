package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.login.bean.User;
import springboot.login.service.LoginService;
import springboot.login.service.RedisService;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@RestController
public class DemoController {
    private static final ExecutorService executorService = new ThreadPoolExecutor(1, 1,
            60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    @Autowired
    private RedisService redisService ;

    @Autowired
    private LoginService loginService ;


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void demoTest(){
        redisService.set("1","value22222");
        System.out.println("redis连接成功");
    }

    @RequestMapping(value = "/mysql",method = RequestMethod.GET)
    public String mysqlTest(){
        User user = new User();
        String username = String.valueOf(UUID.randomUUID());
        user.setUsername(username);
        user.setPassword("");
        user.settypes(0);
        loginService.adduser(user);
        return username;
    }

    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    public String redisTest(){
        String code = String.valueOf(UUID.randomUUID());
        redisService.lPush("list",code);
        return code;
    }

    @RequestMapping(value = "/record",method = RequestMethod.GET)
    public String recordTest(){
        String code = String.valueOf(UUID.randomUUID());
        redisService.lPush("list",code);
        executorService.execute(
                new SeckillRecordTask(code, loginService));
        return code;
    }
}
