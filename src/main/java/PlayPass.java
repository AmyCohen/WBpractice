public class PlayPass {
    public static void main(String[] args) {
        String str = "MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015";
//        String str = "I LOVE YOU!!!";
        //expected answer: !!!vPz fWpM J
        //expected answer:  4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO    shifted by: 2

        System.out.println(playPass(str, 2));
    }


/*
    INSTRUCTIONS:
    1. shift each letter by a given number but the transformed letter must be a letter (circular shift),
    2. replace each digit by its complement to 9,
    3. keep such as non alphabetic and non digit characters,
    4. downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
    5. reverse the whole result.
 */

    public static String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    public static String playPass(String s, int n) {
        String result = "";
        String reversedResult = "";
        String shiftedLetter = "";

        for (int i = 0; i < s.length(); i++) {
            if (alphabetLower.contains(String.valueOf(s.charAt(i))) || alphabetLower.contains(String.valueOf(s.charAt(i)).toLowerCase())) {
                String letter = String.valueOf(s.charAt(i)).toLowerCase();
                int alphabetIndex = alphabetLower.indexOf(letter);
                    if (alphabetIndex + n < alphabetLower.length()){
                        shiftedLetter = String.valueOf(alphabetLower.charAt(alphabetIndex + n));
                    } else {
                        int remaining = (alphabetLower.length()) - alphabetIndex;
                        int newCycle = n - remaining;
                        shiftedLetter = String.valueOf(alphabetLower.charAt(newCycle));
                    }


                    if (i % 2 == 0) {
                        result += shiftedLetter.toUpperCase();
                    } else {
                        result += shiftedLetter.toLowerCase();
                    }

            } else if (isNumber(String.valueOf(s.charAt(i)))){
                int capturedNumber = Integer.parseInt(String.valueOf(s.charAt(i)));
                int shiftedNumber = 9 - capturedNumber;

                result += shiftedNumber;
            } else {
                String specialCharacter = String.valueOf(s.charAt(i));
                result += specialCharacter;
            }
        }

        for (int j = result.length()-1; j >= 0; j--) {

            reversedResult += result.charAt(j);
        }


        return reversedResult;
    }

    public static Boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}