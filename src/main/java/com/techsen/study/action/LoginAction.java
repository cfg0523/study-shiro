package com.techsen.study.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAction {

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login() {
        return "redirect:login.jsp";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        String result = "redirect:login.jsp";

        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,
                    password);
            subject.login(token);
            result = "main";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
