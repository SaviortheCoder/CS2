
import java.util.*;
import java.util.Collections.*;

public class hexagram {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int numCases = 12;
        int[] arr = new int[numCases];
        int[] temp = new int[numCases];
        boolean stop = false;
        ArrayList<Integer> list_of_answers = new ArrayList<>();
        ArrayList<Integer> current_possiblities = new ArrayList<>();
        int result = 0;

        while (stop != true) {

            result = 0;

            // empty the arraylist
            current_possiblities.clear();
            for (int loop = 0; loop < numCases; loop++) {

                // fill the array with 12 int from the user
                arr[loop] = stdin.nextInt();

            }
            // the boolean variable for the function of the loop
            stop = true;

            // go through all the number of cases and if the last 12 numbers are 0 break
            for (int i = 0; i < numCases; i++) {
                if (arr[i] != 0)
                    stop = false;
            }

            if (stop == false) {

                // transferring the data from the og arr to the temp to begin
                for (int i = 0; i < numCases; i++) {
                    temp[i] = arr[i];
                }

                hexagram.recur_swap(temp, 0, current_possiblities);

                // adding the result in the araylist
                for (Integer i : current_possiblities) {
                    result += i;
                }

                // because its accessible every we need to specify the class and then the method
                list_of_answers.add(result / numCases);
            }
        }

        // answers printing method
        for (Integer i : list_of_answers) {
            System.out.println(i);
        }

    }

    // staic because access to all classes and doesnt need an object
    // using recursion to brute force the array
    // we dont need type int for the funtion bc storing in arryalist
    public static void recur_swap(int[] arr, int index, ArrayList<Integer> possible_perms) {

        boolean isPossiblity = true;

        if (index >= arr.length - 1) {

            // all the signs of the star of david taken from our own drawing representation
            // starting at the top down from left to right
            int value = arr[1] + arr[2] + arr[3] + arr[4];
            int row1 = arr[4] + arr[6] + arr[9] + arr[11];
            int row2 = arr[1] + arr[5] + arr[8] + arr[11];
            int row3 = arr[0] + arr[2] + arr[5] + arr[7];
            int row4 = arr[7] + arr[8] + arr[9] + arr[10];
            int row5 = arr[0] + arr[3] + arr[6] + arr[10];

            // if value is not equal to rows then make ispossibility false
            if (value != row1 || value != row2 || value != row3 || value != row4 || value != row5) {
                isPossiblity = false;
            }
            if (isPossiblity == true) {
                possible_perms.add(1);
            } else {
                possible_perms.add(0);
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // swap(array swaping for, destination, and start)
            hexagram.mySwap(arr, i, index);

            hexagram.recur_swap(arr, index + 1, possible_perms);

            hexagram.mySwap(arr, index, i);

        }

    }

    //simple swap function codename myswap
    public static void mySwap(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

// the design of sokudu is a square but the hexagram project is shaped like the
// star of david with no rows or colums
// instead of trying to represent the star to the computer, pass the values to
// the slots of tbe array to attempt a brute force
// approach to determine the total number of permutations