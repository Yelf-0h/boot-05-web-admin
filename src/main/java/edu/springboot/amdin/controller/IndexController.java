package edu.springboot.amdin.controller;

import edu.springboot.amdin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author Yelf
 * @create 2022-09-04-1:53
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String index(User user, Model model, HttpSession session){
        if (StringUtils.hasLength(user.getUserName())&&"123".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:main.html";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }
    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:login";
    }

    @GetMapping("/main.html")
    public String mainPage(){
        return "main";
    }
}
