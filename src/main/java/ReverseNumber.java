import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class ReverseNumber {
    /*
int max value = 2,147,483,647

*/

    public static void main(String[] args) {
        System.out.println(MAX_VALUE);
        int max = MAX_VALUE;
        int neg = -2147483412;
        int mid = 1534236469;
        int n = -2018;

        System.out.println(MAX_VALUE - mid);
        System.out.println(reverse(mid));

    }
    public static int reverse(int x) {

        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x = x *-1;
        }

        String num = x + "";
        String[] numString = num.split("");
        String answer = "";


        if (numString == null){
            throw new Error("Error: int variable is null.");
        }

        if (numString.length < 2) {
            return x;
        }

        if (numString.length > MAX_VALUE) {
            return 0;
        }

        int half = numString.length/2;
        String temp = "";
        String holdNegative = "";

        for (int i = 0; i < half; i++) {

            temp = numString[i];
            numString[i] = numString[numString.length-1-i];
            numString[numString.length-1-i] = temp;

        }
        if (isNegative) {
            answer = "-" + num.join("", numString);
        } else {
            System.out.println(num.join("", numString));
            answer = num.join("", numString);
        }

        try {
            return Integer.parseInt(answer);
        } catch (Exception e) {
            return 0;
        }
    }
}
