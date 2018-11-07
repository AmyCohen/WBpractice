import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumerals {

    /*
    change any positive number fewer than 5000 to Roman numerals
     */
    public static void main(String[] args) {

        romanNumerals(4394);
        romanNumeralsOptimized(4394);
    }

    public static String romanNumerals (int num) {

        //Travis' code - works awesome!
//        public static String roman(int num ) {
            String results = "";
            while (num > 0) {
                if (num >= 1000) {
                    results += "M";
                    num -= 1000;
                } else if (num >= 900) {
                    results += "CM";
                    num -= 900;
                } else if (num >= 500) {
                    results += "D";
                    num -= 500;
                } else if (num >= 400) {
                    results += "CD";
                    num -= 400;
                } else if (num >= 100) {
                    results += "C";
                    num -= 100;
                } else if (num >= 90) {
                    results += "XC";
                    num -= 90;
                } else if (num >= 50) {
                    results += "L";
                    num -= 50;
                } else if (num >= 40) {
                    results += "XL";
                    num -= 40;
                } else if (num >= 10) {
                    results += "X";
                    num -= 10;
                } else if (num >= 9) {
                    results += "IX";
                    num -= 9;
                } else if (num >= 5) {
                    results += "V";
                    num -= 5;
                } else if (num >= 4) {
                    results += "IV";
                    num -= 4;
                } else if (num >= 1) {
                    results += "I";
                    num -= 1;
                }
            }
        System.out.println(results);
            return results;
        }

        private static String romanNumeralsOptimized(int num) {
            String results = "";
            TreeMap<Integer, String> romanNumeralsLookUp = new TreeMap<>();
            romanNumeralsLookUp.put(1000, "M");
            romanNumeralsLookUp.put(900, "CM");
            romanNumeralsLookUp.put(500, "D");
            romanNumeralsLookUp.put(400, "CD");
            romanNumeralsLookUp.put(100, "C");
            romanNumeralsLookUp.put(90, "XC");
            romanNumeralsLookUp.put(50, "L");
            romanNumeralsLookUp.put(40, "XL");
            romanNumeralsLookUp.put(10, "X");
            romanNumeralsLookUp.put(9, "IX");
            romanNumeralsLookUp.put(5, "V");
            romanNumeralsLookUp.put(4, "IV");
            romanNumeralsLookUp.put(1, "I");

            while (num > 0) {
                int filterAmount = romanNumeralsLookUp.floorKey(num);
                results += romanNumeralsLookUp.get(filterAmount);
                num -= filterAmount;
            }
            System.out.println("Optimized Results: " + results);
            return results;
        }

}
