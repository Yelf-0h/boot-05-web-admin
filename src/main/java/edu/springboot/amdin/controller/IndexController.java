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
            User user1 = new User();
            user1.setUserName("zhangsan");
            user1.setPassword("123");
            User user2 = new User();
            user2.setUserName("lisi");
            user2.setPassword("123");
            User user3 = new User();
            user3.setUserName("wangwu");
            user3.setPassword("123");
            User user4 = new User();
            user4.setUserName("zhaoliu");
            user4.setPassword("123");
            session.setAttribute("users", Arrays.asList(user1,user2,user3,user4));


            return "redirect:main.html";
        }else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(){
        return "main";
    }
}
