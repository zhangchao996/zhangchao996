package com.zc.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
public class Hello {
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

    @PostMapping("uselogin")
    public String login(String username, String password, Model model,HttpSession session){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("user",username);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }


    }


}
