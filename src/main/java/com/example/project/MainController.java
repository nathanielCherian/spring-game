package com.example.project;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @GetMapping("/ap-frqs")
    public String apfrqs(){
        return "apfrqs.html";
    }

    @GetMapping("/pair-share")
    public String pairShare(){
        return "pairshare.html";
    }

}
