/* A program that makes change and returns the fewest number of bills and coins as possible
 * Returns the number of each kind of bill and coin to give back as the difference between charged and given
 * Coins: 1, 2, 5, 10, 20, 50 cents, 1, 2 Euros
 * Bills: 5, 10, 20, 50 Euros
*/

import java.util.Arrays;

public class make_change{
      
    public static void make_change(double charged, double given){
        double[] bills_and_coins = {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] new_array = new int[12]; 
      
        if (charged > given){
            throw new IllegalArgumentException("The given amount of money has to be greater or equal to the money charged.");
        }
        
        double change = given - charged;
        double change_ = (double) Math.round(change * 100) / 100;
        double a = change*100;
        double change_1 = Math.round(a * 100.0) / 100.0;
        System.out.println(change_1);

        for (int i = 0; i < bills_and_coins.length; i++){    
            if (change_1 / bills_and_coins[i] >= 1){
                int counter = ((int) Math.floor(change_1 / bills_and_coins[i])); 
                for (int j = 0; j < counter; j++){      
                    change_1 = change_1 - bills_and_coins[i];
                    new_array[i] += 1;
                }               
            }           
        }

        System.out.println("New array: " + Arrays.toString(new_array));
        System.out.println("Charged: " + charged);
        System.out.println("Given: " + given);
        System.out.println("Change: " + change_);
        System.out.println("------------------------------------");

        String[] names = {"50 Euros", "20 Euros", "10 Euros", "5 Euros", "2 Euros", "1 Euro", "50 Cents", "20 Cents", "10 Cents", "5 Cents", "2 Cents", "1 Cent"};
        for (int k = 0; k < names.length; k++){
            System.out.println(names[k] + ": " + new_array[k]);
        }
    }

    public static void main(String[] args){
        make_change(56,1000);
    }
}
