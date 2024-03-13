

import java.util.*;
import java.util.Scanner;
import java.lang.Math;


public class drones {

    final public static int N = 8;
    public static int[] Distance;
    public static int State_of_Board = 0;

    public static void main(String[] args) {

        int num_of_drones = 0;
        boolean is_a_Solution = false;

        String[][] Grid = new String[N][];
        for(int i = 0; i < N ; i++){
            Grid[i] = new String[N];
        }

        // Scanner and input for the first line taking in the drone number
        Scanner stdin = new Scanner(System.in);

        num_of_drones = stdin.nextInt();
        stdin.nextLine();
        int total = (int)Math.pow(2,6*num_of_drones);

        //reading in the grid
        Distance = new int[total];
        for(int loop = 1; loop < N*N; loop++){
            continue;
            //Distance[loop] = stdin.nextInt();
        }

        //taking the user input fo each row
        for(int i = 0; i < N; i++){
            String input_row = stdin.nextLine();

            String[] temp = new String[N];
            temp = input_row.split(" ");
            for(int j = 0; j < N ; j++){
                Grid[i][j] = temp[j];
            }
            
            
            
        }
        //
        for(int row = 0; row < N; row++){
            for(int column = 0 ; column < N; column++){
                //if the string at the current row and column is equal to D than its a drone
                if(Grid[row][column].charAt(0) == 'D'){
                    // test needed
                    int drone_number = Grid[row][column].charAt(1) - 30;
                    

                    int offset_index = (6 * drone_number) - 6;
                    
                    //
                    int position = (row * 8) + column;

                    State_of_Board += position << offset_index;

                }
                if(Grid[row][column].charAt(0) == 'X'){
                    
                }
                if(Grid[row][column].charAt(0) == 'G'){
                    
                }
            }
        }

        /*for(int i = 0; i < N; i ++){
            for(int j = 0; j < N ; j++){
                System.out.print(Grid[i][j] +" ");
            }
            System.out.println(" ");
        }*/

        System.out.println(State_of_Board);
    }

}
//function for if it is a no fly zone
//