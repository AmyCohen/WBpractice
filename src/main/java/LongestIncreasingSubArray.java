import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class LongestIncreasingSubArray {
    public static void main(String[] args) {
        int[] numArray = {1, 4, 6, 8, 8, 9, 10, 11, 12, 13};
        int[] numArray2 = {-1, -4, -6, -8, 8, 9, 10, 11, 12, 13};
        int[] numArray3 = {};
        int[] numArray4 = {3};
        int[] numArray5 = null;
        int[] numArray6 = {1, 1, 1, 2, 3, 3, 4, 1, 2, 1, -3, -2, -1, 0, 1, 2, 3};


        System.out.println(findLengthOfLCIS(numArray2));
    }

    public static int findLengthOfLCIS(int[] nums) {

        int currentCount = 0;
        int hightestCount = 0;
        int currentVal = MIN_VALUE;
        int previousVal = MIN_VALUE;

        if (null == nums) {
            throw new Error("Error: integer array is null");
        }

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {

            currentVal = nums[i];

            if (currentVal > previousVal) {
                currentCount++;
                previousVal = currentVal;
                if (currentCount > hightestCount) {
                    hightestCount = currentCount;
                }
            } else if (currentVal < previousVal){
                currentCount = 1;
                previousVal = currentVal;
            } else if (currentVal == previousVal) {
                currentCount = 1;
            }
        }
        return hightestCount;
    }
}
