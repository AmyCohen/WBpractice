public class TrappedWater {
    //PASSED LEETCODE

    /*
    Given an array of ints that represent the levels of a building, write an algorithm that will return the total units of water that could be trapped by the buildings.

    Example 1: [3, 1, 0, 2, 0] ==> 3 units of water
    Example 2: [3, 1, 0, 2, 3] ==> 6 units of water
     */

    public static void main(String[] args) {

        // [3, 2, 2, 2, 0]
        //-[3, 1, 0, 2, 0]
        //=[0, 1, 2, 0, 0] ==> 3

        /*
        Input: [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 17
        Expected: 6
         */

        /*
        maxLeft [0,1,1,2,2,2,2,3,3,3,3,3]
        actual  [0,1,0,2,1,0,1,3,2,1,2,1]
        -
        =>      [0,0,1,0,1,2,1,0,1,2,1,2]
        correct [0,0,1,0,1,2,1,0,0,1,0,0]



        maxRight[3,3,3,3,3,3,3,3,2,2,2,1]
        actual  [0,1,0,2,1,0,1,3,2,1,2,1]
        -
        =>      [3,2,3,1,2,3,2,0,0,1,0,0]
        correct [0,0,1,0,1,2,1,0,0,1,0,0]


        maxRight[3,3,3,3,3,3,3,3,2,2,2,1]
        maxLeft [0,1,1,2,2,2,2,3,3,3,3,3]

         */

                            //
        int[]buildingLevels = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappedWater(buildingLevels));

    }

    public static int trappedWater(int[] height){
        int[] maxArrayFromLeft = new int[height.length];
        int[] maxArrayFromRight = new int[height.length];
        int maxLeft = 0;
        int maxRight = 0;
        int j = height.length-1;
        int maxUnits = 0;

        for (int i = 0; i < height.length; i++, j--) {
            if(maxLeft < height[i]){
                maxLeft = height[i];
                maxArrayFromLeft[i] = maxLeft;
            } else {
                maxArrayFromLeft[i] = maxLeft;
            }
            if(maxRight < height[j]){
                maxRight = height[j];
                maxArrayFromRight[j] = maxRight;
            } else {
                maxArrayFromRight[j] = maxRight;
            }
        }

        for (int k = 0; k < height.length; k++) {
            if (maxArrayFromRight[k] < maxArrayFromLeft[k]) {
            maxUnits += (maxArrayFromRight[k] - height[k]);
            } else {
            maxUnits += (maxArrayFromLeft[k] - height[k]);

            }
        }
        return maxUnits;
    }
}
