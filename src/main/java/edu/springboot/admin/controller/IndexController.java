package edu.springboot.admin.controller;

import edu.springboot.admin.pojo.User;
import edu.springboot.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

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
        if (StringUtils.hasLength(user.getUserName())&& "123".equals(user.getPassword())){
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


    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/sql")
    public String sql(){
        Long result = jdbcTemplate.queryForObject("select count(*) from t_book", Long.class);
        String sql = "表格的条数是："+result;
/*
        此代码可以在任何地方获取到request，只要是同线程
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();*/
        return sql;
    }
    @Autowired
    UserServiceImpl userService;
    @ResponseBody
    @GetMapping("/getUser")
    public String getUserById(Integer id){
        User userById = userService.getUserById(id);
        return userById.toString();
    }
}
