import java.util.HashSet;
import java.util.Set;

public class LogestSubstringLength {

/*
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:

    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.

    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
    public static void main(String[] args) {
//        String testString = "abcabcd";
//        String testString = "tmmzuxt";
//        String testString = "dvdf";
//        String testString = "cdd";
//        String testString = "pwwkew";
//        String testString = "abcabcbb";
//        String testString = "abcabcbbcdef";
//        String testString = "ohvhjdml";
        String testString = "umvejcuuk";
//        String testString = "anviaj";
        System.out.println(lengthOfLongestSubstring(testString));
    }

    public static int lengthOfLongestSubstring (String s) {

        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        if (s == null) {
            throw new Error("Error: String is null.");
        }

        //enter each letter into a hash set
        //increase "count" for each letter entering that the data structure does NOT already contain
        //keep track of the highest count
        //reset data structure AND count if a repeating character is found
        //return the hightest count

        Set<String> findOriginals = new HashSet<>();
//        int count = 1;
        int highestCount = 0;
        int lastIndexOf = 0;
        int currentIndex = 0;
        int indexOfLastDuplicate = 0;

        for (int i = 0; i < s.length(); i++) {
            String test = String.valueOf(s.charAt(i));
            if (!findOriginals.contains(String.valueOf(s.charAt(i)))) {
                findOriginals.add(String.valueOf(s.charAt(i)));
//                count++;
                if (findOriginals.size() > highestCount) {
                    highestCount = findOriginals.size();
                }
            } else {
//                count = 1;
                findOriginals.clear();

                int indexOf = s.indexOf(s.charAt(i));
                String letter = String.valueOf(s.charAt(indexOf));

                if(i > indexOf || i == 0) {
                    for (int j = indexOf+1; j < i; j++) {
                        findOriginals.add(String.valueOf(s.charAt(j)));
                    }
                findOriginals.add(letter);
                }


            }
        }

        return highestCount;
    }
}


//        count = 1;
//        currentIndex = i;
//
//        if ((i+1) > s.length()-1) {
//
//            findOriginals.clear();
//            findOriginals.add(String.valueOf(s.charAt(i)));
//
//        } else if (s.charAt(i) == s.charAt(0)){
//            i = indexOfLastDuplicate + 1;
//
//            indexOfLastDuplicate = currentIndex;
//            findOriginals.clear();
//            findOriginals.add(String.valueOf(s.charAt(i)));
//
//        } else if (s.charAt(i) == s.charAt(indexOfLastDuplicate)) {
//            findOriginals.clear();
//            i = indexOfLastDuplicate - 1;
//            findOriginals.add(String.valueOf(s.charAt(i)));
//        } else {
//            i = indexOfLastDuplicate + 1;
//
//            indexOfLastDuplicate = currentIndex;
//            findOriginals.clear();
//            findOriginals.add(String.valueOf(s.charAt(i)));
//        }
//    }
//}

