/*

    Created by Michael Hayes
    2020

 */

package com.example.project.mini.games;

import java.util.ArrayList;

public class HangmanPhrases {
    public static ArrayList<String> masterPhraseList = new ArrayList<String>();
    public static String[] masterPhraseArray = new String[]{"computer science a", "coronavirus pandemic", "intellij idea"}; // current "data"


    static {
        for (String phrase : masterPhraseArray){
            masterPhraseList.add(phrase);
        }
    }
}
