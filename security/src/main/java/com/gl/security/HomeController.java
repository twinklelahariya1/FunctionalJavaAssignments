package com.gl.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/hello")
    public String home(){
        return "home.html";
    }
}

