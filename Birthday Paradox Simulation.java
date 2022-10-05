import java.util.Arrays;
import java.util.Random;

public class Birthday_Paradox{   

    public static void number_of_people(int number, int trials, boolean same_as_you){   
        
        double counter = 0;
        double total = 0;
        int counter_int = (int) counter;
        int total_int = (int) total;
 
        for (int j = 0; j < trials; j++){
            int[] new_array = new int[365];
           
            for (int i = 0; i < number; i++){                
                Random rand = new Random(); 
                int value = rand.nextInt(365);            
                new_array[value] += 1; 

            }

            if (same_as_you){
                new_array[14] += 1; 
            }
    
            //System.out.println(Arrays.toString(new_array));
            //System.out.println(new_array[14]);
    
            boolean found = false;
    
            for (int i = 0; i < new_array.length; i++){
                
                if (same_as_you){
                    if (new_array[14] > 1){
                        found = true;
                        break;
                    }

                }
                else {
                    if (new_array[i] > 1){
                        found = true;
                        break; 
                    }
                }            
            }
    
            if (found){
                //System.out.println("Same birthday found!");
                counter += 1;
                total += 1;
                counter_int += 1;
                total_int += 1;
            }
    
            else{
                //System.out.println("The birthdays are all distinct.");    
                total += 1;  
                total_int += 1;  
            }
        }
        
        System.out.printf("Number of people%s: %d %n", same_as_you ? " (including you)" : "", same_as_you ? (number+1) : number);
        System.out.println("Number of successes: " + counter_int);
        System.out.println("Total number of trials: " + total_int);
        System.out.printf("The probability %s is: %.2f %% %n", same_as_you ? "of you having the same birthday as somebody" : "of any two people sharing the same birthday",(counter/total)*100);

    }
    
    public static void main(String[] args){

        for (int i = 0; i < 400; i += 25){
            number_of_people(i,10000, false);
            System.out.println("-----------------------------");
        }

        for (int i = 0; i < 400; i += 25){
            number_of_people(i,10000, true);
            System.out.println("-----------------------------");
        }
    }
}
