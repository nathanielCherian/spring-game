package com.example.project.ap.practice;

/** QUESTION #1 **/

    /** The method longestStreak is intended to determine the longest substring of consecutive identical characters in the parameter str and print the result.
        For example, the call longestStreak("CCAAAAATTT!") should print the result "A 5" because the longest substring of consecutive identical characters is "AAAAA". **/

public class Consecutive {
    int totalConsecutive = 0;
    String character = "";

    public Consecutive() { // Default constructor so as to not return any errors
    }

    public void longestStreak(String str) {
        int temp = 0;               // Initializing variables to store future temp values and total consecutive appearances and what character does it
        int length = str.length();
        String first;
        String second;

        for (int i = 0; i <= length; i++) {

            if ((length - i) == 0) {        // Since substrings are used, multiple if statements are required for when the substring reaches the end of the string given so that the OutOfBoundsException error is not thrown
                first = str.substring(i);   // assigning letter in string to first
                second = str.substring(i);  // assigning letter after first to second
            }
            else if ((length - i) == 1) {
                first = str.substring(i, i+1);
                second = str.substring(i+1);
            }
            else {
                first = str.substring(i, i+1);
                second = str.substring(i+1, i+2);
            }


            if (first.equals(second)) {  // If the first letter equals the second letter then one is added to temp and the for statement repeats
                temp++;
            }

            else {  // If the first doesn't equal the second, add one because there is still one letter that isn't accounted for
                temp++;

                if (temp > totalConsecutive) {
                    totalConsecutive = temp; // If the temp that we have been calculating is greater than the previous totalConsecutive value, store the new value
                    temp = 0;  // Reset temp value to zero
                    character = first; // Assign the character that appeared consecutively to character variable
                }

                else {
                    temp = 0;  // reset temp value even if temp is not greater than previous totalConsecutive value
                }
            }
        }
        //System.out.println(character + " " + totalConsecutive); // Print the letter that appears the most consecutively and the number of times it appears consecutively
    }

    public String getCharacter(){
        return character;
    }

    public int getTotalConsecutive(){
        return totalConsecutive;
    }

    public static void main (String[] args) {  // implementation of method for testing purposes
        Consecutive consecutive = new Consecutive();
        consecutive.longestStreak("MRSJGKAIIISJSJJJSSWWWKKDDNCNCNNNNNNNGG");
    }

}

