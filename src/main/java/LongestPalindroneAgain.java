public class LongestPalindroneAgain {
    public static void main(String[] args) {
//        String sample = "babadd";
//        String sample = "abacab";
        String sample = "kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv";
        // examples are "bab" or "aba";
        // 0 1 2 3 4
        // b a b a d d x y z
        // z y x d d a b a b

        System.out.println(longestPalindrome(sample));
    }

    public static String longestPalindrome(String s) {

        int half = s.length() / 2;

        StringBuffer answer = new StringBuffer();
        StringBuffer buffer = new StringBuffer();

        int letterCount = 1;
        int highest = 0;
        String returnThis = "";

        //FROM MIDDLE GO LEFT
        for (int i = half; i >= 0; i--) {
            buffer.append(String.valueOf(s.charAt(i)));
            String original = buffer.toString();
            StringBuffer opposite = buffer.reverse();
            String compare = opposite.toString();

            if (original.equals(compare)) {
                answer.delete(0, answer.length());
                answer.append(buffer.toString());
                letterCount = answer.length();
                if (letterCount > highest) {
                    highest = letterCount;
                    returnThis = answer.toString();
                }
            }
            buffer.reverse();
        }
        buffer.delete(0, buffer.length());

        //FROM MIDDLE GO RIGHT
        for (int i = half-1; i < s.length(); i++) {
            buffer.append(String.valueOf(s.charAt(i)));
            String original = buffer.toString();
            StringBuffer opposite = buffer.reverse();
            String compare = opposite.toString();

            if (original.equals(compare)) {
                answer.delete(0, answer.length());
                answer.append(buffer.toString());
                letterCount = answer.length();
                if (letterCount > highest) {
                    highest = letterCount;
                    returnThis = answer.toString();
                }
            }
            buffer.reverse();
        }
        buffer.delete(0, buffer.length());


        //FROM MIDDLE GO BOTH DIRECTIONS
        int j = half+1;
        int k = half -1;

        //how to make it add the center letter than add both side simutaneously.
        for (int i = half-1; i >= 0 || j < s.length(); i--, j++) {
            if(s.length() % 2 == 0) {
                buffer.append(String.valueOf(s.substring(i, j)));
            } else {
                buffer.append(String.valueOf(s.substring(i-1, j + 1)));
            }
            String original = buffer.toString();
            StringBuffer opposite = buffer.reverse();
            String compare = opposite.toString();

            if (original.equals(compare)) {
                answer.delete(0, answer.length());
                answer.append(buffer.toString());
                letterCount = answer.length();
                if (letterCount > highest) {
                    highest = letterCount;
                    returnThis = answer.toString();
                }
            buffer.delete(0, buffer.length());
            }
        }


        //FROM FRONT GO TO BACK
        for (int i = 0; i < s.length(); i++) {
            buffer.append(String.valueOf(s.substring(i, s.length())));
            String original = buffer.toString();
            StringBuffer opposite = buffer.reverse();
            String compare = opposite.toString();

            if (original.equals(compare)) {
                answer.delete(0, answer.length());
                answer.append(buffer.toString());
                letterCount = answer.length();
                if (letterCount > highest) {
                    highest = letterCount;
                    returnThis = answer.toString();
                }
            }
            buffer.delete(0, buffer.length());
        }


        return returnThis;
    }
}
