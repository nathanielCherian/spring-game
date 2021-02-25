package com.example.project;


import com.example.project.People.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    private People people = new People();

    @GetMapping("/ap-frqs")
    public String apfrqs(Model model){
        System.out.println(people);
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


}
