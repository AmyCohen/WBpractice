import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numArray = {3, 2, 5, 5, 4};
//        int[] numArray = {2, 7, 11, 15};
        int target = 10;

        System.out.println(Arrays.toString(twoSum(numArray, target)));
        System.out.println(Arrays.toString(optimizedTwoSum(numArray, target)));
    }

    //O(n^2) time O(n) space
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(i != j) {
                    if (nums[i] + nums[j] == target) {
                        answer[0] = i;
                        answer[1] = j;
                        return answer;
                    }

                }
            }
        }
        return answer;
    }

    //O(n) time O(n) space
    public static int[] optimizedTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numStorage = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numStorage.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int solution = target - nums[i];
            if (numStorage.containsKey(solution)) {
                return new int[] {i, numStorage.get(solution)};
            }
        }
        throw new IllegalArgumentException("No target found");
    }
}
