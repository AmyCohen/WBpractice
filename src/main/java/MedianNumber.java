
import java.util.Arrays;

public class MedianNumber {
    public static void main(String[] args) {

        int[] numArray1 = {1, 3, 5, 7, 9};
        int[] numArray2 = {2, 4};

        System.out.println(findMedianSortedArrays(numArray1, numArray2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        int fullLength = nums1Size + nums2Size;
        int half = fullLength/2;
        int[] numsArray = new int[fullLength];

        if (nums1 == null || nums2 == null) {
            throw new Error("Error: An array is null. Cannot proceed with null array");
        }

        if (fullLength == 0) {
            throw new Error("Error: Both arrays are empty.");
        }

        if (nums1Size == 1 && nums2Size == 0) {
            return (double) nums1[0];
        }

        if (nums2Size == 1 && nums1Size == 0) {
            return (double) nums2[0];
        }

        int index = 0;
        for (int i = 0; i < fullLength; i++) {
            if (i < nums1Size) {
                numsArray[i] = nums1[i];
            } else {
                numsArray[i] = nums2[index];
                index++;
            }
        }

        Arrays.sort(numsArray);

        double median = 0.0;

        if (fullLength % 2 == 0) {
            median = (double) (numsArray[half-1] + (double) numsArray[half])/2;
            return median;
        } else {
            median = numsArray[half];
            return median;
        }
    }
}
