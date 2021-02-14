package com.example.project.ap.practice;
import java.util.Scanner;

public class Invitation {
    public static void rsvp(String[] args){ // dont use static void main use a constructor to construct values
        String option1 = " ";

        System.out.println("Hello! Will you be attending this event? Please enter 'true' for yes and 'false' for no."); // Determines if rsvp is true or false
        Scanner keyboard = new Scanner(System.in); // dont use
        boolean rsvp = keyboard.nextBoolean();// pass boolean from html to here rsvp

        if(rsvp == true){ // use a method to check if true then do the rest in the same method

            System.out.println("We're so happy you could attend! Please enter what selection you would like to choose: 1 for beef, 2 for chicken, 3 for pasta, and any integer from 4 to 9 for fish.");
            int selection = keyboard.nextInt(); // again pass int from html to a constructor
            option1 = "Thanks for attending. You will be served "; // Prints out thank you for attending and states what they will be served.
            switch(selection){
                case 1: option1 += "beef."; // make option1 a class base var
                    break;
                case 2: option1 += "chicken.";
                    break;
                case 3: option1 += "pasta.";
                    break;
                default: option1 += "fish.";
            }
        }
        else{ // If rsvp = false, there is simply an apology.
            option1 = "Sorry you can't make it.";
        }
        System.out.println(option1);
        keyboard.close(); // Closes scanner
    }
}
