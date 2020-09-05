package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FirstThymeleafController {
    @RequestMapping("/html")
    public String getHtml(Model model){
        List<User> userList = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setName("优就业");
        u1.setAge(18);

        User u2 = new User();
        u2.setId(12);
        u2.setName("周扒皮");
        u2.setAge(17);

        User u3 = new User();
        u3.setId(3);
        u3.setName("小可爱");
        u3.setAge(10);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        model.addAttribute("message","我是你的小宝贝啊");
        model.addAttribute("userList",userList);
        model.addAttribute("flag",true);
        return "index2";
    }
    @GetMapping("/fragment")
    public String fragment() {
        return "index5";
    }


}
