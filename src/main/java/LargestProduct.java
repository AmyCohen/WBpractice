import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestProduct {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(-12);
        list1.add(-13);
        list1.add(-1);
        list1.add(-99);
//        list1.add(1);
        list1.add(-3);
        list1.add(-89);

        System.out.println("List = " + list1);
        System.out.println(largestOf3Product((ArrayList<Integer>) list1));
    }

    //Solved using a sorted list.
    public static Integer largestOf3Product(ArrayList<Integer> list) {
        Collections.sort(list);
        System.out.println("Sorted List = " + list);

        if (list.size() < 3 || list.size() == 0) {
            return null;
        }

        int endListIndex = list.size();
        Integer large1 = list.get(endListIndex - 1);
        Integer large2 = list.get(endListIndex - 2);
        Integer large3 = list.get(endListIndex - 3);

        Integer low1 = list.get(0);
        Integer low2 = list.get(1);

        int origHighResult = large1 * large2 * large3;
        int edgeLowWithHigh= low1 * low2 * large1;

        Integer result = null;


        if (origHighResult > edgeLowWithHigh) {
            result = origHighResult;
        } else {
            result = edgeLowWithHigh;
        }

        return result;
    }

}
