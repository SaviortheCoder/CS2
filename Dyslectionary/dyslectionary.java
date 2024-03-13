
//shift + option + f   AUTO INDENT

import java.util.*;

public class dyslectionary {

    public static void main(String[] args) {

        int word_counter = 0;
        int row_counter = 0;
        String blank = "";
        String str = " doesnt_matter "; // first intial word from the user to set in the while arg
        // ArrayList<word_dsy> mylist = new ArrayList();

        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<word_dsy>> mylist = new ArrayList<>();

        while (!str.equals("0") && row_counter < 100) {

            str = in.nextLine();

            // the current row
            ArrayList<word_dsy> list = new ArrayList<>();

            // while each dict input is not blank keep looping
            while (!blank.equals(str) && !str.equals("0") && word_counter < 100) {

                word_dsy user_str = new word_dsy(str);

                list.add(user_str);

                // the second to keep getting the dict words ad store the dict word from the
                // user
                str = in.nextLine();

                word_counter++;

            }
            word_counter = 0;
            row_counter++;

            // sorting an arraylist by passing a new mycomparator object along with the list
            // your comparing
            Collections.sort(list, new myCompartor());

            mylist.add(list);
        }
        for (ArrayList<word_dsy> i : mylist) { // going thru the row
            for (word_dsy j : i) { // going thru the columns
                System.out.println(j.toString());
            }
            // printing a new line to seperate the list
            System.out.println("");
        }
        in.close();
    }

}

class word_dsy implements Comparable<word_dsy> {

    public String cur_string;

    // constructor this.var = pass_in_val;
    public word_dsy(String word) {
        this.cur_string = word;
    }

    // return the current object
    public String toString() {
        return String.format("%10s", cur_string);
    }

    //
    public int compareTo(word_dsy str) {
        // getting the very last variale in that string
        char last_letter = str.cur_string.charAt(str.cur_string.length() - 1);

        // geting the ery last variable in the cur_string
        char cur_last_let = cur_string.charAt(cur_string.length() - 1);

        if (last_letter != cur_last_let) {
            return cur_last_let - last_letter;
        } else {
            int len_lastlet = str.cur_string.length();
            int len_curlet = this.cur_string.length();

            return (len_curlet < len_lastlet) ? -1 : 1;
        }
    }

}

// class with custom compare methods
class myCompartor implements Comparator<word_dsy> {

    //
    public int compare(word_dsy word1, word_dsy word2) {
        char word1_firstLet = word1.cur_string.charAt(word1.cur_string.length() - 1);
        char word2_firstLet = word2.cur_string.charAt(word2.cur_string.length() - 1);

        if (word1_firstLet != word2_firstLet) {
            return word1_firstLet - word2_firstLet;
        } else {
            int length_word1 = word1.cur_string.length();
            int length_word2 = word2.cur_string.length();

            return (length_word1 < length_word2) ? -1 : 1;
        }
    }
}
