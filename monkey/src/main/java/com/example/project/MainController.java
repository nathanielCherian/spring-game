package com.example.project;

import AndrewFrq1.LightSequence;
import com.example.project.ap.practice.Invitation;
import com.example.project.mini.games.Hangman;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import AndrewFrq1.StringStruct;

import com.example.project.ap.practice.PasswordGenerator;
import com.example.project.ap.practice.Consecutive;

@Controller
public class MainController {

    Hangman control_java = new Hangman();

    @GetMapping("/ap-practice")
    public String apPractice() {
        return "ap-practice/menuAP.html";
    }

    @GetMapping("/ap-practice/andrew") // root for Andrew page
    public String apPracticeAndrew(Model model){
        model.addAttribute("StringStruct",new StringStruct());
        return "ap-practice/Andrew/andrew.html";
    }
    @GetMapping("/frq1")
    public String Display2(@ModelAttribute("StringStruct") StringStruct stringStruct , Model model)
    {
        System.out.println(stringStruct);
        LightSequence lightSequence = new LightSequence(stringStruct.getField1());
        model.addAttribute("Sequenceone", lightSequence.seq);
        lightSequence.remove(lightSequence.seq, stringStruct.getField3());
        lightSequence.printStraightline(stringStruct.anInt1, stringStruct.anInt2);
        model.addAttribute("InsertedSegment", lightSequence.insertSegment(stringStruct.field2, stringStruct.anInt1));
        model.addAttribute("removeSegment", lightSequence.newSeq);
        model.addAttribute("mathReturn", lightSequence.thing);
        return "ap-practice/Andrew/frq1.html";
    }

   @PostMapping("/frq1")
   public String Display(@ModelAttribute("StringStruct") StringStruct stringStruct , Model model)
   {
        System.out.println(stringStruct);
       LightSequence lightSequence = new LightSequence(stringStruct.getField1());
       model.addAttribute("Sequenceone", lightSequence.seq);
       lightSequence.remove(lightSequence.seq, stringStruct.getField3());
       lightSequence.printStraightline(stringStruct.anInt1, stringStruct.anInt2);
       model.addAttribute("InsertedSegment", lightSequence.insertSegment(stringStruct.field2, stringStruct.anInt1));
       model.addAttribute("removeSegment", lightSequence.newSeq);
       model.addAttribute("mathReturn", lightSequence.thing);
       return "ap-practice/Andrew/frq1.html";
   }



    @GetMapping("/ap-practice/nakul") // root for Nakul page
    public String apPracticeNakul(@RequestParam(name="str", required=false,  defaultValue="ccaaaaattt") String str, Model model){
        Consecutive consecutive = new Consecutive();
        consecutive.longestStreak(str);

        model.addAttribute("consecutiveChar", consecutive.getCharacter());
        model.addAttribute("consecutiveTotal", consecutive.getTotalConsecutive());

        return "ap-practice/nakul";
    }

    @GetMapping("/labs") // root for menuLabs page
    public String Labs(){
        return "labs/menuLabs";
    }

    @GetMapping("/labs/Pythagorean") // root for Pythagoras page
    public String Pythagoras(){
        return "labs/Pythagorean";
    }





    @GetMapping("/ap-practice/sara") // root for Sara page
    public String apPracticeSara(@RequestParam (name = "rsvp", required = true, defaultValue = "true") String rsvp, @RequestParam(name = "selection", required = false, defaultValue = "1") String prefix, Model model){

        // Unit 3 FRQ, Question #1
        Invitation invitation = new Invitation();
        // use invitation to get option1
        model.addAttribute("rsvp", invitation.getClass());
        model.addAttribute("selection", invitation.getClass());

        return "ap-practice/sara.html";
    }


    @GetMapping("/labs/Tip")
    public String Tips()
    {
        return "labs/tipCalc";
    }








    @GetMapping("/ap-practice/michael") // root for Michael page
    public String apPracticeMichael(@RequestParam (name="length", required=false, defaultValue="4") String length, @RequestParam(name="prefix", required=false, defaultValue="A") String prefix, Model model){ // use multiple @RequestParam annotations if you have multiple variables in HTML (correct way to reference them?)

        // UNIT 5 FRQ PART A
        PasswordGenerator newPassword = new PasswordGenerator(Integer.parseInt(length), prefix);


        model.addAttribute("passwords", newPassword.getPasswordList()); // s: goes to variable name in HTML
        model.addAttribute("passwordGenerated", newPassword.pwGen());

        return "ap-practice/michael"; // use path to HTML file without .html OR it does not recognize model attributes!
    }


    @GetMapping("/labs/hangman")
    public String hangmanGame(@RequestParam (name="alphaSelection", required=false, defaultValue="A") String alphaSelection, Model model) {


        control_java.checkLetter(Character.toLowerCase(alphaSelection.charAt(0))); // gets char from button return, passed it in to the existing control

        model.addAttribute("displayPhrase", control_java.getCurrentPhraseForDisplay()); // updates current display phrase, is set in a simple <p> in html
        model.addAttribute("guessesRemaining", control_java.getRemainingGuesses()); // displays guesses remaining

        return "labs/hangman";
    }
}
