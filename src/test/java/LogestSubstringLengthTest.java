import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogestSubstringLengthTest {

    @Test
    void happyPath() {
        String testString = "abc";
        int expected = 3;
        int actual = LogestSubstringLength.lengthOfLongestSubstring(testString);
        assertEquals(expected, actual);
    }

    @Test
    void lengthIsZero() {
        String testString = "";
        int expected = 0;
        int actual = LogestSubstringLength.lengthOfLongestSubstring(testString);
        assertEquals(expected, actual);
    }

    @Test
    void lengthIsOne() {
        String testString = "a";
        int expected = 1;
        int actual = LogestSubstringLength.lengthOfLongestSubstring(testString);
        assertEquals(expected, actual);
    }

    //Not sure how to test a null without getting canceled for a null pointer exception
//    @Test
//    void lengthIsNull() {
//        String testString = null;
//        Error expected = new Error("Error: String is nulll.");
//        int actual = LogestSubstringLength.lengthOfLongestSubstring(testString);
//        assertEquals(expected, actual);
//    }


    @Test
    void lengthIsLarge() {
        String testString = "abcabcduvwxyzzz";
        int expected = 10;
        int actual = LogestSubstringLength.lengthOfLongestSubstring(testString);
        assertEquals(expected, actual);
    }
}