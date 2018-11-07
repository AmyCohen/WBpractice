import java.util.*;

public class UserStories {
    public static void main(String[] args) {
        int userStories = 28;
        System.out.println(estimateHours(userStories));

    }

    public static String estimateHours(int numUserStories) {
        ///// Used Refactor -> Extract -> Method /////
        TreeMap<Integer, ArrayList<Integer>> userStoriesCompleted = setupDatabase();
        ////////////// * END DATABASE * //////////////

        //combinedHours is for adding up each entry in the ArrayList if there are more than one
        int combinedHours = 0;
        //averageHours and count are used to find the average from the combinedHours
        int averageHours = 0;
        //count is the number of entries in the ArrayList for that particular key
        int count = 0;
        //
        int upperLimit = 0;
        int lowerLimit = 0;

        //MUST perform a null check - if nothing is above the key requested a null will return.
        if (null == userStoriesCompleted.ceilingKey(numUserStories)) {
            //If the no keys exist above the requested key, I've chosed to set the value to 0 since you would not
            //typically have a 0 amount of user stories
            upperLimit = 0;
            //Defaul to using the lower key if the upper is null
            lowerLimit = userStoriesCompleted.floorKey(numUserStories);
        //MUST perform a null check - if nothing is below the key requested a null will return.
        } else if (null == userStoriesCompleted.floorKey(numUserStories)){
            //Defaul to using the lower key if the upper is null
            upperLimit = userStoriesCompleted.ceilingKey(numUserStories);
            //If the no keys exist below the requested key, I've chosed to set the value to 0 since you would not
            //typically have a 0 amount of user stories
            lowerLimit = 0;
        } else {
            //If neither the upper or lower limits trip the null checks, then set both of them.
            upperLimit = userStoriesCompleted.ceilingKey(numUserStories);
            lowerLimit = userStoriesCompleted.floorKey(numUserStories);
        }

        int upperDifference = upperLimit - numUserStories;
        int lowerDifference = numUserStories - lowerLimit;

        //determine the least difference between the requested number of stories and the available comparison
        if (upperDifference < lowerDifference) {
            //check to see if the key found has multiple entries for hours it took to complete
            if (userStoriesCompleted.get(upperLimit).size() > 1) {
                for (int entry : userStoriesCompleted.get(upperLimit)){
                    combinedHours += entry;
                    count++;
                }
                //if there were multiple entries for hours, then run these lines to find the average
                averageHours = combinedHours/count;
                return "Closest Comparison: \n" +
                        "User Stories = " + upperLimit + "\n" +
                        "Average Hours = " + averageHours;
            } else {
                //if there was only 1 entry for the key, then return the dataset
                return "Closest Comparison: \n" +
                        "User Stories = " + upperLimit + "\n" +
                        "Average Hours = " + userStoriesCompleted.get(upperLimit);
            }
        //if the amount between the lower key is less than the amount of the upper key, run this portion
        } else {
            //if there were multiple entries for hours, then run these lines to find the average
            if (userStoriesCompleted.get(lowerLimit).size() > 1) {
                for (int entry : userStoriesCompleted.get(lowerLimit)){
                    combinedHours += entry;
                    count++;
                }
                averageHours = combinedHours/count;
                return "Closest Comparison: \n" +
                        "User Stories = " + lowerLimit + "\n" +
                        "Average Hours = " + averageHours;
            } else {
                //if there was only 1 entry for the key, then return the dataset
                return "Closest Comparison: \n" +
                        "User Stories = " + lowerLimit + "\n" +
                        "Average Hours = " + userStoriesCompleted.get(lowerLimit);
            }
        }
    }

    ///// Setting up a "preexisting database of information /////
    private static TreeMap<Integer, ArrayList<Integer>> setupDatabase() {
        TreeMap<Integer, ArrayList<Integer>> userStoriesCompleted = new TreeMap<>();

        for (int i = 0; i < 100; i++) {

            double numOfStories = Math.random()*100+i;
            double numOfHours = Math.random()*500+i;
            int changedStories = (int) numOfStories;
            int changedHours = (int) numOfHours;

            if (i % 4 == 0) {
                ArrayList<Integer> hoursToComplete = new ArrayList<>();
                hoursToComplete.add(changedHours);
                hoursToComplete.add(changedHours * 2);
                hoursToComplete.add(changedHours * 3);
                userStoriesCompleted.put(changedStories, hoursToComplete);
            } else if (i % 5 == 0) {
                ArrayList<Integer> hoursToComplete = new ArrayList<>();
                hoursToComplete.add(changedHours);
                hoursToComplete.add(changedHours *2);
                userStoriesCompleted.put(changedStories, hoursToComplete);
            } else {
                ArrayList<Integer> hoursToComplete = new ArrayList<>();
                hoursToComplete.add(changedHours);
                userStoriesCompleted.put(changedStories, hoursToComplete);
            }
        }
        return userStoriesCompleted;
    }
    ////////////////// * END DATABASE SETUP * //////////////////
}
