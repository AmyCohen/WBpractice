public class ReverseWords {

    public static void main(String[] args) {

        String str = "happy";
        String sentence = "Amy is a happy camper";

        System.out.println(reverseWord(str));
        System.out.println(reverseSentence(sentence));
    }

    public static String reverseWord(String str) {
        String reversedString = "";
        String temp;
        String[] splitWord = str.split("");
        int half = splitWord.length / 2;

        if (null == str || str.length() == 1 || str.trim().length() <= 1) {
            return str;
        }

        for (int i = 0; i < half; i ++) {
            temp = splitWord[i];
            splitWord[i] = splitWord[splitWord.length - 1 - i];
            splitWord[splitWord.length - 1 - i] = temp;
        }
        String answer = reversedString.join("", splitWord);
        return answer;
    }

    public static String reverseSentence(String str) {
        StringBuffer buffer = new StringBuffer();
        String[] splitString = str.split(" ");

        for (int i = 0; i < splitString.length; i++) {
            buffer.append(reverseWord(splitString[i]));
            buffer.append(" ");
        }

        return buffer.toString().trim();
    }


}
