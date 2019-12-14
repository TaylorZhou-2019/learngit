package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.login.bean.DangerList;
import springboot.login.bean.Record;
import springboot.login.bean.User;
import springboot.login.service.DangerListService;
import springboot.login.service.LoginService;
import springboot.login.service.RecordService;


@Controller
@RequestMapping("/user")
class UserController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(String username, String password,String type) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.settypes(0);
        int verify = loginService.verifyLogin(user);
        if (verify == -1) {
            loginService.adduser(user);
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

//    @RequestMapping("/update")
//    @ResponseBody
//    public String upUser(String id,String username, String password,String type) {
//        User user = new User();
//        user.setId(Long.parseLong(id));
//        user.setUsername(username);
//        user.setPassword(password);
//        user.settypes(0);
//        loginService.upduser(user);
//        return "修改成功";
//    }

//    @RequestMapping("/del/{id}")
//    @ResponseBody
//    public String delUser(@PathVariable("id")  long id) {
//        loginService.deluser(Long.parseLong(String.valueOf(id)));
//        return "删除成功";
//    }

//    @GetMapping("/getAllUser")
//    @ResponseBody
//    public Iterable<User> getAllUser() {
//        return loginService.getAll();
//    }

//    @RequestMapping("/getAlldanger")
//    @ResponseBody
//    public Iterable<DangerList> getAlldanger() {
//        // 查询所有的用户数据
//        return dangerListService.getAll();
//    }
}
