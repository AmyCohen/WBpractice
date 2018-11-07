public class LongestPalindrone {

    /*
    WORKS BUT TAKES TOO LONG DURING TESTS TO PASS ALL TESTS - IT TIMES OUT.
     */
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

        StringBuffer answer = new StringBuffer();
        StringBuffer buffer = new StringBuffer();

        int count = 0;
        int index = 0;
        int letterCount = 1;
        int highest = 0;
        String returnThis = "";

        while (index < s.length()) {
            for (int i = count; i < s.length(); i++) {
                buffer.append(String.valueOf(s.charAt(i)));
                String original = buffer.toString();
                StringBuffer opposite = buffer.reverse();
                String compare = opposite.toString();

                if (original.equals(compare)) {
                    answer.delete(0, answer.length());
                    answer.append(buffer.toString());
                    letterCount = answer.length();
                }
                buffer.reverse();
            }
            buffer.delete(0, s.length() - index);
            count++;
            index++;
            if(letterCount > highest) {
                highest = letterCount;
                returnThis = answer.toString();
            }
            letterCount = 1;

        }
        return returnThis;
    }
}
