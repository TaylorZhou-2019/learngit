package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.login.bean.Suspect;
import springboot.login.bean.User;
import springboot.login.service.DangerListService;
import springboot.login.service.LoginService;
import springboot.login.service.SuspectService;


@Controller
@RequestMapping("/suspect")
class SuspectController {

    @Autowired
    private SuspectService suspectService;
    @Autowired
    private DangerListService DangerListService;

    @GetMapping("/getAllsuspect")
    @ResponseBody
    public Iterable<Suspect> getAllsuspect() {
        return suspectService.getAll();
    }

//    @RequestMapping("/update/{id}")
//    @ResponseBody
//    public String upStatus(@PathVariable("id") long id) {
//        DangerListService.updStatus(id);
//        return "处理成功";
//    }

//    @RequestMapping("/getAlldanger")
//    @ResponseBody
//    public Iterable<DangerList> getAlldanger() {
//        // 查询所有的用户数据
//        return dangerListService.getAll();
//    }
}
