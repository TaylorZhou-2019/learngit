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
        long times = (long)(10 * Math.random());
        String username = String.valueOf(UUID.randomUUID());
        for (int i = 0;i<times;i++) {
            user.setUsername(username);
            user.setPassword("");
            user.settypes(0);
            loginService.adduser(user);
            if (i > 2) {
                user = loginService.findUser(user);
                if (i > 5) {
                    user.setPassword("123");
                    loginService.upduser(user);
                    if (i > 8) {
                        loginService.deluser(user.getId());
                    }
                }
            }
        }
        return username;
    }

    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    public String redisTest(){
        String code = String.valueOf(UUID.randomUUID());
        redisService.get(code);
        long expire = (long)(60 * Math.random());
        redisService.set(code, 1, expire);
        if(expire >> 1 == 0) {
            redisService.lPush("list", code);
        }
        if(expire % 5 == 0) {
            redisService.remove("list");
            redisService.lPush("list", code);
        }
        redisService.get(code);
        return code;
    }

    @RequestMapping(value = "/record",method = RequestMethod.GET)
    public String recordTest(){
        String code = String.valueOf(UUID.randomUUID());
        redisService.get(code);
        long expire = (long)(60 * Math.random());
        redisService.set(code, 1, expire);
        if(expire >> 1 == 0) {
            redisService.lPush("list", code);
        }
        if(expire % 5 == 0) {
            redisService.remove("list");
            redisService.lPush("list", code);
        }
        redisService.get(code);
        executorService.execute(
                new SeckillRecordTask(code, loginService));
        return code;
    }
}
