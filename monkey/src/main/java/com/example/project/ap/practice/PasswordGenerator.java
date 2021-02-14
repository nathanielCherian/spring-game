/*


    AP UNIT % FRQ PART A

 */

package com.example.project.ap.practice;

import java.util.ArrayList;

public class PasswordGenerator {
    /**
     * This question involves the implementation of the PasswordGenerator class, which generates strings containing initial passwords for
     * online accounts. The PasswordGenerator class supports the following functions.
     *
     *  - Creating a password consisting of a specified prefix, a period, and a randomly generated numeric portion of specified length
     *  - Creating a password consisting of the default prefix "A", a period, and a randomly generated numeric portion of specified length
     *  - Reporting how many passwords have been generated
     *
     *  Write the complete PasswordGenerator class. Your implementation must meet all specifications and conform to the example.
     */

    private int randNumLength; // attribute to store length of randomized string of numbers
    private String prefix; // attribute to store prefix of password

    private static int totalPasswordCount = 0; // static to store same value in all of PasswordGenerator objects
    private static ArrayList<String> passwordList= new ArrayList<>();

    /**
     * Constructor that takes both a number length and a prefix string
     * @param numLength
     * @param p
     */
    public PasswordGenerator(int numLength, String p) {
        randNumLength = numLength;
        prefix = p;
    }

    /**
     * Constructor that only takes a length of randomized number string, sets prefix to "A"
     * @param numLength
     */
    public PasswordGenerator(int numLength) {
        randNumLength = numLength;
        prefix = "A";
    }

    /**
     * Generates password with specified (or default) prefix and specified length of random numbers
     * @return
     */
    public String pwGen() {
        String randNumbers = ""; // 0 numbers, variable to store randomized string of numbers
        for (int i = 0; i < randNumLength; i++) {
            randNumbers += (int) (Math.random() * 10); // creates a string of numbers 0-9 and concatenates for the given length of numbers
        }
        String password = prefix + "." + randNumbers; // clarification of password, concatenates prefix and randNumbers together

        totalPasswordCount++;
        setPasswordList(password);

        return password;
    }

    /**
     * Returns number of passwords for entire PasswordGenerator class
     */
    public int pwCount() {
        return this.totalPasswordCount;
    }

    public static void setPasswordList(String newPassword) {
        passwordList.add(newPassword); // simple ArrayList to store all of the passwords
    }

    public ArrayList<String> getPasswordList() {
        return passwordList;
    }
    public static void main(String[] args) {

        PasswordGenerator pw1 = new PasswordGenerator(4, "chs");
        System.out.println(pw1.pwCount());
        System.out.println(pw1.pwGen());
        System.out.println(pw1.pwGen());
        System.out.println(pw1.pwCount());

        PasswordGenerator pw2 = new PasswordGenerator(6);
        System.out.println(pw2.pwCount());
        System.out.println(pw2.pwGen());
        System.out.println(pw2.pwCount());
        System.out.println(pw2.pwCount());

    }
}

