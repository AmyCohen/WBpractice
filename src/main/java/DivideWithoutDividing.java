import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class DivideWithoutDividing {
    public static void main(String[] args) {
        int num = -7;
//        System.out.println(divide(7, -3));
        System.out.println("MIN = " + Integer.MIN_VALUE);
        System.out.println("MAX = " + Integer.MAX_VALUE);
        System.out.println("OUTPUT: " + divide(-1, 1));
//        System.out.println("experiment = " + (Integer.MIN_VALUE / -2));
//        System.out.println("experiment 2 = " + (Integer.MIN_VALUE * -1));
    }

    public static int divide(int dividend, int divisor) {

        //need to keep track of a 4 different possibilities
        // 1. negative dividend && negative divior => produces positive answer
            // * the dividend will need to remain SMALLER than the divisor
        // 2. negative dividend && positive divior => produces negative answer
            // * the dividend will need to be converted to positive and remain larger than the divisor or vice versa
        // 2. positive dividend && negative divior => produces negative answer
            // * the divisor will need to be converted to positive and remain smaller than the dividend or vice versa
        // 2. positive dividend && positive divior => produces positive answer
            // * the dividend will need to remain LARGER than the divisor

        int count = 0;

        if (dividend < 0 && divisor < 0) {

            //MIN_VALUE is not reading correctly when divided by 1. All other numbers are unaffected.
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                while (dividend <= divisor) {
                    dividend -= divisor;
                    count++;
                }
            }
        } else if (dividend < 0 && divisor > 0) {
            if (dividend == Integer.MIN_VALUE && divisor == 1) {
                return Integer.MIN_VALUE;
            } else {
                if(dividend == Integer.MIN_VALUE) {
                    dividend = Integer.MAX_VALUE;
                } else {
                    dividend *= -1;
                }
                while (dividend >= divisor) {
                    dividend -= divisor;
                    count--;

                    //solves the minvalue issue but affect all calculations and messes everything else up
                    if (count == -1 && (Integer.MIN_VALUE-divisor) == dividend) {
                        dividend +=1;
                    }
                }
            }
        } else if (dividend > 0 && divisor < 0) {
            if (divisor == Integer.MIN_VALUE) {
                divisor = Integer.MAX_VALUE;
            } else {
                divisor *= -1;
            }
            while (dividend >= divisor) {
                dividend -= divisor;
                count--;
            }
        } else if (dividend > 0 && divisor > 0) {
            while (dividend >= divisor) {
                dividend -= divisor;
                count++;
            }
        }

        return count;
    }
}
