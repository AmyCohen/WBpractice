import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableScores {

    /*
    Turn an array of string with numbers appearing to be part of the string into a hash table where you can find matching keys and add the integers together.

    You have an array of strings like [sounders 4, KC city 2, lions 1, ghouls 4, lions 4, sounders 0, KC city 1]
     */

    public static void main(String[] args) {
        String [] rawData = {"sounders 4", "KC city 2", "lions 1", "ghouls 4", "lions 4", "sounders 0", "KC city 1"};
        System.out.println("original data:" + Arrays.toString(rawData));

        totalScores(rawData);
        System.out.println("table with values added: " + totalScores(rawData));
    }

    public static Hashtable<String, Integer> totalScores(String[] scrambled) {
        //Hashtable info: https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html
        Hashtable<String, Integer> sorted = new Hashtable<>();

        //for each data point in the array: "sounders 4"
        for (String data : scrambled) {
            String newKey = "";
            int newScore = 0;

            //Idea to use scanner: https://codereview.stackexchange.com/questions/159457/determine-if-an-input-is-an-integer-a-double-or-a-string
            Scanner scanner = new Scanner(data);

            //while that data of "sounders 4" has a more info...
            while (scanner.hasNext()) {
                String dataPoint = scanner.next();

                //check to see if the datapoint pulled by the scanner is an integer using the helper method created.
                if (!isInteger(dataPoint)) {

                    //if it is NOT an integer and it is the first value in the key, then just add it.
                    if(newKey.equals("")) {
                        newKey += dataPoint;

                    //if it is NOT an integer BUT the key already has a value, add the 2nd value with a space separating it: "KC + space + city"
                    } else {
                            newKey += " " + dataPoint;
                    }

                //if the next datapoint pulled from the scanner IS an integer based on the helper function created, then add that as the value.
                } else {
                    newScore += Integer.parseInt(dataPoint);
                }
            }

            //if the key already exists in the hashtable...
            if (sorted.containsKey(newKey)) {
                //get the original value
                int storedScore = sorted.get(newKey);
                //add the original value to the new value
                int updatedScore = storedScore + newScore;
                //reenter the value with the updated value into the table
                sorted.put(newKey, updatedScore);

            //if the key does not already exist in the table..
            } else {
                //add both the key and the value to the hashtable
                sorted.put(newKey, newScore);
            }
        }

        return sorted;
    }


    //Helper function for determining if a value is an integer
    //https://www.quora.com/What-is-the-function-of-a-isInteger-in-Java
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(String.valueOf(input));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
