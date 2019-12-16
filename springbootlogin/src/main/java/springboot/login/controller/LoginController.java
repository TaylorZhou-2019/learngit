package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import springboot.login.WebSecurityConfig;
import springboot.login.bean.User;
import springboot.login.service.LoginService;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

//    @GetMapping("/")
//    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
//
//        return "logout";
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/hotelPhoRecg")
    public String hotelPhoRecg() {
        return "hotelPhoRecg";
    }

    @GetMapping("/policeRecord")
    public String policeRecord() {
        return "policeRecord";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/policeDanger")
    public String policeDanger() {
        return "policeDanger";
    }

    @GetMapping("/policeUserMgt")
    public String policeUserMgt() {
        return "policeUserMgt";
    }
    @GetMapping("/policeSuspect")
    public String policeSuspect() {
        return "policeSuspect";
    }@GetMapping("/policeCalendar")
    public String policeCalendar() {
        return "policeCalendar";
    }

    @PostMapping("/loginVerify")
    @ResponseBody
    public String loginVerify(String username, String password, HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int verify = loginService.verifyLogin(user);
        if (verify != -1) {
//            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            if (verify == 0)
                return "{\"success\":\"1\"}";
            else
                return "{\"success\":\"2\"}";
        } else
            return "{\"success\":\"0\"}";
    }

    //注册方法
    @PostMapping("/register")
    public String register(String username, String password, HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.settypes(0);
        int verify = loginService.verifyLogin(user);
        if (verify == -1) {
            loginService.adduser(user);
            return "login";
        } else {
            return "register";
        }
    }

//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
//        return "redirect:/login";
//    }


}
