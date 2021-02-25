package com.example.project;


import com.example.project.People.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


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

    @GetMapping("/bitcoin")
    public String bitcoin(){
        return "bitcoin.html";
    }

    @GetMapping("/readme")
    public String readme(){
        return "readme.html";
    }

    @GetMapping("/people")
    public String people(){
        return "people.html";
    }

}
