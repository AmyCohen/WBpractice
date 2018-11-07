public class PhoneInterview {


/*

 [1, 2, 5, 6, 7, 4, 5, 9, 10]
 [1, 2]==
       [5, 6, 7]         //3
                [4, 5]
                      [9]

 method that takes an array of any number
 and returns the longest sub array with incrementing numbers
 -yes can be negative
 -null check
 -can not be matching
 -one array = 1
 -{3, 5, 7, 9} = 1


 method longestIncrement (int[] nums)

 variables
 count = 1
 highest count so far

 for loop to look at each number and compare with it next neighbor
 if index+ 1 ==index[at the plus one]

 count++

 if count > highestcount
 highestcount = count

 else {
 count = 1
 }



 [1, 2, 3, 5, 6] //3
 [1, 2, 4, 5, 6] //2

 */



    public static void main(String[] args) {
        // int[] nums = {1, 2, 5, 6, 7, 4, 5, 9, 10};
        // int[] nums = null;
        int[] nums = {};



//        System.out.println(longestIncrement(nums));
        printTable(4);

    }

    public static int longestIncrement (int[] nums) {
        int count = 1;
        int highestCount = 1;

        // throw new NullPointerException("thing i want to say");

        if (nums == null) {
            throw new Error("Error: Array is null.");
        }

        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length-1; i++) {

            // if (nums[i+1] == null) {
            //   return highestCount;
            // }

            if (nums[i] + 1 == nums[i+1]) {
                count++;

                if (count > highestCount) {
                    highestCount = count;
                }
            } else {
                count = 1;
            }
        }

        return highestCount;
    }


/*
  PROBLEM DOMAIN * EXAMPLES * PSEUDO CODE
  print out matrix to console.

  Write a method that take int n for any amount and create a grade school times table.
  -not negative
  -no edge cases

  method (int n)

  for loop lenth of 5
  multipy each number row * n
  StringBuffer to hold value
  print result


printTable(4);
1  2  3  4
2  4  6  8
3  6  9  12
4  8  12 16
*/

    public static void printTable(int n) {
        int result = 0;
        String builder = "";

        for (int row = 1; row <= n; row++) { //1
            for (int col = 1; col <= n; col++) { //4
                builder = String.format("%02d", (row * col));
                builder = builder.replace("0", " ");
                System.out.print(builder + "  ");
            }
            System.out.println();
        }
    }
}
