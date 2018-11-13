import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestName {

    public static void main(String[] args) {
        System.out.print("How many names would you like to compare? ");
        Scanner numNames = new Scanner(System.in);
        int n = numNames.nextInt();

        //create list of names
        List<String> namesList = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            System.out.print("Name #" + i + "? ");
            Scanner nameInput = new Scanner(System.in);
            String name = nameInput.next();
            namesList.add(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
        }

        //find max length
        int maxLength = 1;
        for (int i = 0; i < namesList.size(); i++) {
            String eachName = namesList.get(i);
            int eachLength = eachName.length();
            if (eachLength > maxLength) {
                maxLength = eachLength;
            }
        }

        //return longest name
        List<String> longestNamesList = new ArrayList<String>();
        for (int i = 0; i < namesList.size(); i++) {
            String eachName = namesList.get(i);
            int eachLength = eachName.length();
            if (eachLength == maxLength) {
                longestNamesList.add(namesList.get(i));
            }
        }
        if (longestNamesList.size() == 1) {
            System.out.println(longestNamesList.get(0) + "'s name is longest.");
        } else {
            System.out.println(longestNamesList.get(0) + "'s name is longest.");
            System.out.println("(There was a tie, so the first entry was returned.)");
        }
    }
}