import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//NOT WORKING YET - HAVEN'T SPENT TIME LOOKING AT IT - DINNER CALLS!

public class RomanNumeralsToInts {
    public static void main(String[] args) {
//        String s = "MCMXCIV"; //1994
//        String s = "MDCCCLXXXIV"; //1884
        String s = "MDCCCXLVII"; //1847
//        String s = "LVIII"; //58
//        String s = "IX"; //9
//        String s = "III"; //3
//        String s = "MMCCCXCIX"; //2399
//        String s = "DCXXI"; //621
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {

        if (s.length() == 0) {
            return 0;
        }

        if (s == null) {
            throw new Error("Error: string is null.");
        }

        int results = 0;
        int hold = 0;
        int compute = 0;
        String item1 = "";
        String item2 = "";

        Map<String, Integer> romanNumeralsLookUp = new HashMap<>();
        romanNumeralsLookUp.put("M", 1000);
        romanNumeralsLookUp.put("CM", 900);
        romanNumeralsLookUp.put("D", 500);
        romanNumeralsLookUp.put("CD", 400);
        romanNumeralsLookUp.put("C", 100);
        romanNumeralsLookUp.put("XC", 90);
        romanNumeralsLookUp.put("L", 50);
        romanNumeralsLookUp.put("XL", 40);
        romanNumeralsLookUp.put("X", 10);
        romanNumeralsLookUp.put("IX", 9);
        romanNumeralsLookUp.put("V", 5);
        romanNumeralsLookUp.put("IV", 4);
        romanNumeralsLookUp.put("I", 1);

        StringBuffer buffer = new StringBuffer();

        int j = 1;
        for (int i = 0; i < s.length(); i++, j++) {
            item1 = String.valueOf(s.charAt(i));
            buffer.append(item1);

            if (j < s.length()) {
                item2 = String.valueOf(s.charAt(j));
                buffer.append(item2);
            } else {
                buffer.delete(0,buffer.length());
                item2 = "A";
            }

            if (item1.equals(item2)) {
                results += (romanNumeralsLookUp.get(item1) + romanNumeralsLookUp.get(item2));
                i++;
                j++;
            } else if(romanNumeralsLookUp.containsKey(buffer.toString())) {
                results += romanNumeralsLookUp.get(buffer.toString());
                i++;
                j++;
            } else {
                results += romanNumeralsLookUp.get(item1);
            }
            buffer.delete(0, buffer.length());
        }

        return results;
    }
}
