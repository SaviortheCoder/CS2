
import java.util.*;

public class SGA{

    public static void main(String[] args){


        String cur_studentname;
        Integer student_counter = 0; 
        long possible_pres_pairs = 0;

        Scanner in = new Scanner(System.in);
                                                System.out.println("number of student"); //TODO 
        int number_of_students = in.nextInt();
        in.nextLine();

        //hashmap to go from single character to the total number of pres/vice pres pairs
        //switching the order of the integer and string we are able to distinguish each students name
        //by using the student_counter to index
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for(int i = 0; i < number_of_students; i++){

            //reads the students from the user
            cur_studentname = in.nextLine();
            

            //the counter for the current student to distinguish distinct students
            student_counter++;

            char firstletter = cur_studentname.charAt(0);

            for(Integer loop : map.keySet()){

                

                //the if checks the first letter is equal to the first letter of current name && the value of i is not equal to j 
                //plus filters repeating names from potenital pairs (like james and james)
                if(firstletter == map.get(loop).charAt(0) && student_counter != loop && !cur_studentname.equals(map.get(loop))){   
                    possible_pres_pairs++; //incrementing the possible pairs
                    
                }
            }

            map.put(student_counter, cur_studentname);



        }
        
        possible_pres_pairs *= 2;
        System.out.println(possible_pres_pairs);
        in.close();
    }
}

