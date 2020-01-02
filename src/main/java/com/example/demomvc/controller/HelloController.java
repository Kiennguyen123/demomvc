package com.example.demomvc.controller;

import com.example.demomvc.model.GoodBye;
import com.example.demomvc.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam("name") String name,@RequestParam("number2") int number2,
                        @RequestParam("number1") int number1){
        //@RequestParam đọc tham số truyền vào trên url, nếu có nhiều param cách nhau bởi dấu &
        //Thêm 2 param là 2 số rồi tính tổng
        int sum = number1 +number2;
        model.addAttribute("sum",sum);
        Hello hello = new Hello();
        model.addAttribute("hello",hello.getHello());
        model.addAttribute("user",name);
        return "hello";
    }

    @RequestMapping("/bye")
    public String goodBye(Model model){
        GoodBye goodBye = new GoodBye();
        model.addAttribute("goodBye",goodBye.getGoodBye());
        //Controller do du lieu ra view
        model.addAttribute("test","Test data");
        return "goodBye";
    }

    @RequestMapping("/blog")
    public String view(Model model){
        return "blog";
    }

    @RequestMapping("/sum")
    @ResponseBody
    public int sumNumber(@RequestParam("number1") int number1,
                         @RequestParam("number2") int number2){

        return number1+number2;
    }

    @RequestMapping("/home")
    public String home(Model model){
        return("home");
    }
    @RequestMapping("/detail")
    public String detal(Model model){
        return("detail");
    }
}
