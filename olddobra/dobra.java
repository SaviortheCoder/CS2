//code by Savion Gay
//February 1st,2024
//Happy Black History month

//shift opt f auto indent

import java.util.*;

public class dobra {

    public static String input;
    final public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {

        boolean answer = true;
        int ret;

        Scanner stdin = new Scanner(System.in);
        input = stdin.nextLine();

        ret = dobra.solution_count();
        System.out.println(ret);


    }

    // ------------------------------------------------------------------------------
    // function Checkers
    public static boolean myCheck() {
        return checkConsonants() && checkL() && checkVowels();
    }

    // ------------------------------------------------------------------------------
    public static boolean checkL() {

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'L') {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------------------------
    public static boolean checkVowels() {

        // starting at 1 to be able to look on both sides of the char
        for (int i = 1; i < input.length() - 1; i++) {
            if (isVowel(input.charAt(i - 1)) && isVowel(input.charAt(i)) && isVowel(input.charAt(i + 1))) {
                return false;
            }
        }
        // if we didnt find 3 vowels true
        return true;
    }

    // ------------------------------------------------------------------------------
    public static boolean checkConsonants() {
        // starting at 1 to be able to look on both sides of the char
        for (int i = 1; i < input.length() - 1; i++) {
            if ((!isVowel(input.charAt(i - 1)) && !isUnderscore(input.charAt(i - 1)))
                    && (!isVowel(input.charAt(i)) && !isUnderscore(input.charAt(i)))
                    && (!isVowel(input.charAt(i + 1)) && !isUnderscore(input.charAt(i + 1)))) {
                return false;
            }
        }
        // if we didnt find 3 consonants true
        return true;

    }

    // ------------------------------------------------------------------------------
    // utility function to check for vowels
    public static boolean isVowel(char single) { // change
        if (single == 'A' || single == 'E' || single == 'I' || single == 'O' || single == 'U') {
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------------
    // utility function to check for an underscore
    public static boolean isUnderscore(char cur_character) {
        if (cur_character == '_') {
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------------
    public static int solution_count() {

        // base case the users string that could not work/is valible solution
        if (dobra.checkConsonants() == false || input.length() == 0 || dobra.checkVowels() == false)
            return 0;

        return recur_Sol(0);

    }

    // function with backtracking
    // counting the amount of solutions

    public static int recur_Sol(int index) {

        int ret = 0;

        if (input.length() == index)
            return 0;

        // inputing the numbers at the underscore to try the valiable letters of the
        // alphabet
        for (int i = index; i < input.length(); i++) {
            if (isUnderscore(input.charAt(i))) {
                for (int j = 0; j < ALPHABET.length(); j++) {
                    // going thru the string
                    String previous_input = input.toString();

                    // input[i] = alphabet[j]; line of code in c vs java below
                    input = input.substring(0, i) + ALPHABET.charAt(j) + input.substring(i + 1);

                    

                    // recursive part of the backtrack

                    // We may have a potential solution
                    if (dobra.checkConsonants() == true && dobra.checkVowels() == true) {
                        // at the end of the string
                        if (input.length() -1 == index) { //

                            // if we have an L
                            if (dobra.checkL() == true) {

                                // Print test statment
                                
  /*ret here*/                  ret += 1 + recur_Sol(index + 1);

                                //System.out.println(input);

                            }
                            // theres no L
                            else {
                                //reseting part of backtracking
                                input = previous_input;
                                continue;
                            }
                        }
                        // not at the end of the string
                        else {

                            // Print test statment
                            
/*ret here*/                ret += 1 + recur_Sol(index + 1);

                          // System.out.println(input);
                        }

                    } else {
                        // reseting
                        input = previous_input;
                        continue;
                    }

                }
            }
        }

        // backtrack steps
        /// go thru the string
        // recurs
        // reset

        return ret;
    }
}
// function to check if the string has an L
// funciton for checking for 3 consonants
// functions for checking if theres 3 squential vowels
// function for checking called isConsisent() or isChecking()
//