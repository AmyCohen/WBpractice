public class StringManipulation {
    public static void main(String[] args) {
        String url = "http://www.code.org/hour of code.html";
        removeSpaces(url);
    }

    public static String removeSpaces(String url) {
        String space = "%20";
        String[] messyUrl = url.split("");

        String result = "";

        for(int i = 0; i < messyUrl.length; i++) {
            if (messyUrl[i].equals(" ")) {
                messyUrl[i] = space;
            }
        }
        System.out.println(result.join("", messyUrl));
        return result.join("", messyUrl);
    }
}
