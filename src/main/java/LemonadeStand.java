/*
Note:

0 <= bills.length <= 10000
bills[i] will be either 5, 10, or 20.
 */

//FIX THIS! IT'S NOT THE AMOUNT IT IS THE BILL PRESENTED!!!

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LemonadeStand {
    public static void main(String[] args) {

//        int[] bills = {5, 5, 5, 10, 20}; //true
//        int[] bills = {5,5,10,10,20}; //false
//        int[] bills = {10, 10}; //false
//        int[] bills = {5,10,5,20}; //true

        int[] bills = {5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20}; //true

        System.out.println((lemonadeChange(bills)));
    }

    public static boolean lemonadeChange(int[] bills) {
        int currentBill = 0;
        int drinkCost = 5;
        int fiverBill = 0;
        int tennerBill = 0;
        int twentyBill = 0;
        int totalChangeOnHand = 0;
        int changeNeeded = 0;
        boolean correctChange = false;

        for(int i = 0; i < bills.length; i++) {
            totalChangeOnHand = (5*fiverBill) + (10*tennerBill) + (20 * twentyBill);
            currentBill = bills[i];

            if (totalChangeOnHand == 0 && currentBill > drinkCost) {
                return false;

            } else if (currentBill == drinkCost) {
                fiverBill++;

            } else if (currentBill == 10){
                tennerBill++;
                changeNeeded = ((currentBill/drinkCost) -1) * drinkCost;

                if (changeNeeded == drinkCost) {
                    fiverBill--;
                }

                if (totalChangeOnHand < 0) {
                    return false;
                } else {
                    correctChange = true;
                }
            } else if (currentBill == 20) {
                twentyBill++;
                changeNeeded = ((currentBill/drinkCost) -1) * drinkCost;

                if(tennerBill > 0 && fiverBill > 0) {
                    tennerBill--;
                    fiverBill--;
                    if (totalChangeOnHand < 0) {
                        return false;
                    } else {
                        correctChange = true;
                    }

                } else if (fiverBill > 2) {
                    fiverBill -= 3;

                    if (totalChangeOnHand < 0) {
                        return false;
                    } else {
                        correctChange = true;
                    }
                } else if (fiverBill < 3) {
                    return false;
                }

            }
        }
        return correctChange;
    }




}
