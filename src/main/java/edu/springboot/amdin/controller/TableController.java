package edu.springboot.amdin.controller;

import edu.springboot.amdin.exception.UserTooManyException;
import edu.springboot.amdin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yelf
 * @create 2022-09-04-2:15
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basicTable(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTable(HttpSession session){
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
        List<User> users = Arrays.asList(user1,user2,user3,user4);
        if (users.size()>3){
            throw new UserTooManyException();
        }
        session.setAttribute("users", users);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){
        int a = 1/0;
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editableTable(){
        return "table/editable_table";
    }

}
