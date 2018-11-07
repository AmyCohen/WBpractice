import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class ZigZagConversation {

    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
        String s = "qiinggopdgterivtxaviyspdbjecqicislxyrlpwtjaktygsadayvpdyajaqtdylovjhgydbjfoefuwfxwduniunrvfkydvoygvghykqfyvlstqrqwnfejvyeaieegsempntnxmvxjgrcwkuuzazivznxhtbpmicdxxrwjotsumvqwpnvrodonsmumpmazodwlwuxknpezmxxeksvyymlqyheptepjilxeiurxlvzasweerbcpnphnzmdssueahbhpvynivmiqioubqzqfqavpmaieumhbpqrkqgulsdbcryejzwrpwofioppkbylsoecekwrebvhvtleshxheloobdflgdxyrdcvobnsckbxdoexybgcnvsoaychbbfveksulhpnrqlwfptdsahfxbwxbyefbmafwsahcpwthjqmajrtlaykcwidwoixcifadfjfwgafrquscllpmlaoiktgacgdmlfpsrwozxvqppirbthphjfrtyxtadypogegxdwwasmpjxjmsqbzbgquhopjtqykwfqtippkjdbsakfvciudplzybphwfggblzwvqnfzqitttaoxjkbaxcyarfxynfzygxvwkaxdjtyetobeyeewheyamxzzdaajyvikyfnjalnubqaaxfyglwgxuhxzizkiussuaidavswxjxziezopvwnrgmsqndyjvsexahyyauxltwvxvlnshcmpqefdjdmhyqeaaeyczvnstksovfhehvuzzzclfqsdjwdjbelczawtmojhtslcnfdpffakysphqssrwfvyhstt";
//        String s = "ABCD";
        System.out.println(convert(s, 600));
//        System.out.println(convert(s, 3));
    }

    /*
    Input: "ABCD"
            2
    Output: "ACDB"
    Expected: "ACBD"
Stdout:
[[A, B], [C, null], [D, null], [null, null]]
     */

    public static String convert(String s, int numRows) {

        if (s.length() < 3 || numRows == 1){
            return s;
        }

        String[][] matrix = new String[s.length()][numRows];
        StringBuffer buffer = new StringBuffer();
//        int rowTracker = 0;
        int rowTracker = 0;
        int row = 0;

        int colTracker = 0;
        int col = 0;
        int index = 0;

        while (index < s.length()) {
//            if (row != numRows && row % numRows == 0 || (row+1) % numRows == 0) {
            if (row % (numRows-1) == 0) {
                while (rowTracker < numRows && index < s.length()) {
                    matrix[row][col] = String.valueOf(s.charAt(index));
                    index++;
                    rowTracker++;
                    col++;
                    colTracker = 0;
                }
                row++;
                col = 0;
                rowTracker = 0;
            }
            //breaking when [row = 4][(4-1)-4]
            colTracker++;
            int smallSize = numRows;
            if (index < s.length()) {
                if (numRows == 2) {
                    matrix[row][numRows-smallSize] = String.valueOf(s.charAt(index));
                    smallSize--;
                } else {
                    matrix[row][(numRows - 1) - colTracker] = String.valueOf(s.charAt(index));
                    index++;
                    row++;
                }
                smallSize = numRows;
            }
        }
        if (index > s.length()-1) {
            if (s.length() == numRows || numRows > s.length()) {
                for(int i = 0; i < s.length(); i++) {
                    buffer.append(matrix[0][i]);
                }
                return buffer.toString();
            }

            for (int i = 0; i < matrix[i].length; i++) {
                for (int j = 0; j < matrix.length; j++) {

                    if (matrix[j][i] != null) {
                        buffer.append(matrix[j][i]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return buffer.toString();
    }
}
