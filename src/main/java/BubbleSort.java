import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] numArray = {5, 1, 4, 3, 8, 0, -22};
        System.out.println(Arrays.toString(numSort(numArray)));
    }

    public static int[] numSort(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int count = 0;

        return numSortHelper(nums, count);
    }

    public static int[] numSortHelper(int[] nums, int count) {
        count =0;
        int increaseIndex = 1;

        for (Integer i = 0; i < nums.length; i++) {
            if (increaseIndex < nums.length) {
                if (nums[i] > nums[i + 1]) {
                    int switchNums = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = switchNums;
                    increaseIndex++;
                    increaseIndex += count;
                } else {
                    count++;
                    increaseIndex++;
                }
            } else if (count == (nums.length-1)) {
                return nums;
            } else {
                return numSortHelper(nums, count);
            }
        }

        return nums;
    }
}
