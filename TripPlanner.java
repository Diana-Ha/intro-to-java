import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class TripPlanner {
    /*
    This program will provide the following information to help the user plan his/her trip
    based on user input:
    - Budget in local currency
    - Local time
    - Country's area in miles^2
     */

    private static final int HOURS_PER_DAY = 24;
    private static final int MIN_PER_HOUR = 60;
    private static final int SEC_PER_MIN = 60;
    private static final int MIDNIGHT = 0;
    private static final int NOON = 12;
    private static final double KM2_TO_MILES2 = 0.386102;
    private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public static void main(String[] args) {
        greetUser();
        calculateBudget();
        calculateTimeDifference();
        calculateCountryArea();
        //calculateDistance();
    }

    public static void greetUser() {
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        Scanner inputDest = new Scanner(System.in);
        String destination = inputDest.nextLine();
        System.out.println("Great! " + destination + " sounds like a great place to vacation!");
        createDivider();
    }

    public static void calculateBudget() {
        System.out.print("How many days are you going to spend travelling? ");
        Scanner inputDays = new Scanner(System.in);
        int numDays = inputDays.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        Scanner inputSpend = new Scanner(System.in);
        double spend = inputSpend.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        Scanner inputCurrency = new Scanner(System.in);
        String currency = inputCurrency.next();
        System.out.print("How many " + currency + " are there in 1 USD? ");
        Scanner inputConversion = new Scanner(System.in);
        double dollarConversion = inputConversion.nextDouble();
        System.out.print("\n");
        System.out.println("If you are travelling for " + numDays + " days that is the same as "
                + (numDays * HOURS_PER_DAY) + " hours or "
                + (numDays * HOURS_PER_DAY * MIN_PER_HOUR) + " minutes or "
                + (numDays * HOURS_PER_DAY * MIN_PER_HOUR * SEC_PER_MIN) + " seconds.");
        System.out.println("If you are going to spend " + currencyFormatter.format(spend)
                + " USD that means per day you can spend up to " + currencyFormatter.format( spend/numDays) + " USD.");
        System.out.println("Your total budget in " + currency + " is " + currencyFormatter.format( spend * dollarConversion) + " "
                + currency + ", which per day is " + currencyFormatter.format(spend * dollarConversion / numDays) + " " + currency + ".");
        createDivider();
    }

    public static void calculateTimeDifference() {
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        Scanner inputTimeDiff = new Scanner(System.in);
        int timeDiffInput = inputTimeDiff.nextInt();
        int timeDiffCalc = timeDiffInput;
        int changeInDays = timeDiffInput/HOURS_PER_DAY;

        //if input is positive
        if (timeDiffInput >= 0) {
            if (Math.abs(timeDiffCalc) >= HOURS_PER_DAY) {  //if input is 24 hours or more
                while (Math.abs(timeDiffCalc) >= HOURS_PER_DAY) {
                    timeDiffCalc = Math.abs(timeDiffCalc) - HOURS_PER_DAY;
                }
            }
            System.out.println("That means that when it is midnight at home it will be " + (MIDNIGHT + timeDiffCalc)
                    + ":00 (+" + changeInDays + " days) in your travel destination \nand when it is noon at home it " +
                    "will be " + (NOON + timeDiffCalc) + ":00 (+" + changeInDays + " days).");
        } else { //if input is negative
            if (Math.abs(timeDiffCalc)>=HOURS_PER_DAY) {  //if input is 24 hours or more
                while (Math.abs(timeDiffCalc)>=HOURS_PER_DAY) {
                    timeDiffCalc = Math.abs(timeDiffCalc) - HOURS_PER_DAY;
                }
                timeDiffCalc *= -1;
            }
            //map real time to military time
            Integer[] militaryTimeList = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};

            System.out.println("That means that when it is midnight at home it will be " + militaryTimeList[HOURS_PER_DAY + timeDiffCalc]
                    + ":00 (" + (changeInDays-1) + " days) in your travel destination \nand when it is noon at home it " +
                    "will be " + (NOON + timeDiffCalc) + ":00 (" + changeInDays + " days) in your travel destination.");
        }
        createDivider();
    }

    public static void calculateCountryArea() {
        System.out.print("What is the square area of your destination country in km2? ");
        Scanner inputArea = new Scanner(System.in);
        int area = inputArea.nextInt();
        System.out.println("That is equivalent to " + df2.format(area * KM2_TO_MILES2) + " miles squared.");
        createDivider();
    }

/*    public static void calculateDistance() {
        System.out.print("")
    }*/

    public static void createDivider() {
        System.out.println("***********\n");
    }
}
