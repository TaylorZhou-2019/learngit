package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import springboot.login.WebSecurityConfig;
import springboot.login.bean.DangerList;
import springboot.login.bean.Record;
import springboot.login.bean.User;
import springboot.login.service.DangerListService;
import springboot.login.service.LoginService;
import springboot.login.service.RecordService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;


@Controller
@RequestMapping("/record")
class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private DangerListService dangerListService;

    @RequestMapping("/getAll")
    @ResponseBody
    public Iterable<Record> getAll() {
        // 查询所有的用户数据
        return recordService.getAll();
    }

    @RequestMapping("/getAlldanger")
    @ResponseBody
    public Iterable<DangerList> getAlldanger() {
        // 查询所有的用户数据
        return dangerListService.getAll();
    }
}
