
//shift + opt + f auto indent
import java.util.*;

public class connect {
    // declaring it statically because we need to access it outside the scope of
    // this class
    public static ArrayList<Set<Integer>> list_networks;

    public static void main(String[] args) {

        long number_of_computers = 0;
        long num_computer_connections = 0;
        int answer = 0;

        Scanner stdin = new Scanner(System.in);

        // taking the input from the user for the first input line
        number_of_computers = stdin.nextLong();
        num_computer_connections = stdin.nextLong();

        list_networks = new ArrayList<>();

        for (int i = 1; i <= number_of_computers; i++) {
            // represents each computer
            Set<Integer> computer = new HashSet<>();

            // adding to the set and then adding the set to the arraylist
            computer.add(i);
            list_networks.add(computer);

        }

        for (int i = 0; i < num_computer_connections; i++) {

            // taking in the value of the answer the user provides
            answer = stdin.nextInt();
            if (answer == 1) {
                // taking in the other 2 inputs to be connected
                int computer1 = stdin.nextInt();
                int computer2 = stdin.nextInt();

                int computer1_index = 0;
                int computer2_index = 0;

                // create a union() because we need to union the 2 points given together
                int size = list_networks.size();
                for (int j = 0; j < size; j++) {

                    // since its an arraylist you cannot index without using the method gets to get the index
                    if (list_networks.get(j).contains(computer1)) {
                        computer1_index = j;
                    }
                    if (list_networks.get(j).contains(computer2)) {
                        computer2_index = j;
                    }

                }
               
                //union the 2 sets together
                Set<Integer> mySet = new HashSet<>(list_networks.get(computer1_index));
                Set<Integer> mySet2 = new HashSet<>(list_networks.get(computer2_index));
                mySet.addAll(mySet2);

                // delped with debugging/key debugging stragery
                // System.out.println(mySet);

                list_networks.set(computer1_index, mySet);

                // if the computer are not connected than we removed the element
                // if both indexes are the same this means both elements are in the same set
                if (computer2_index != computer1_index) {
                    // removed the extra element from the set
                    list_networks.remove(computer2_index);
                }

            } else if (answer == 2) {
                // print the average connectivities
                // functions for avg connectivity
                avg_connect();

            } else {
                System.out.println("Invalid Choice");
            }
        }
        stdin.close();
    }

    //function for finding and printing the average connectivity
    public static void avg_connect() {
        long numerator_sum = 0;
        long denominator = 0;

        //formuala for finding the average connectivity
        for (Set<Integer> item : list_networks) {
            int num_set = item.size();
            numerator_sum += num_set * num_set;
        }
        denominator = list_networks.size();
        System.out.println(simplify_frac(numerator_sum, denominator));
    }

    //takes in 2 long values the numerator and de
    //used the GCD and then found the numerator and denominator then print both as a string
    public static String simplify_frac(long numerator, long denominator) {

        String ret = "";
        long divisor = 0;
        long new_numerator = 0;
        long new_denominator = 0;

        divisor = connect.gcd(numerator, denominator);

        new_numerator = numerator / divisor;
        new_denominator = denominator / divisor;

        // return a fraction as a string
        ret = Long.toString(new_numerator) + "/" + Long.toString(new_denominator);

        return ret;
    }

    // euclidsALgorithim for finding the GCD
    public static long gcd(long num1, long num2) {

        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);

    }

}
