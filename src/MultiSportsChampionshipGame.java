import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class MultiSportsChampionshipGame {
    // declare variables
    private static final int MAX_NUMBER_OF_MEDALS = 3;
    private static int totalMedals;
    private static MedalRecord medals;
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {

        // create a Scanner object to read input from file
        Scanner input = null;
        try {
            input = new Scanner(new File(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        // get user input from file
        medals = getUserInput(input);

        // calculate total number of medals
        totalMedals = calculateTotalMedals(medals);

        // display the result
        displayMedals(medals);

        // check if the user earned medal
        checkIfEarnedMedal(totalMedals);

        // write results to output file
        writeToOutputFile(totalMedals);
    }

    // gets the user input
    public static MedalRecord getUserInput(Scanner input) {
        MedalRecord medals = new MedalRecord(input.nextInt(), input.nextInt(), input.nextInt());
        return medals;
    }

    // calculates the total number of medals
    public static int calculateTotalMedals(MedalRecord medals) {
        int total = medals.getGoldMedals() + medals.getSilverMedals() + medals.getBronzeMedals();
        return total;
    }

    // displays the results of the medals earned
    public static void displayMedals(MedalRecord medals) {
        System.out.println("Number of gold medals: " + medals.getGoldMedals());
        System.out.println("Number of silver medals: " + medals.getSilverMedals());
        System.out.println("Number of bronze medals: " + medals.getBronzeMedals());
        System.out.println("Total medals earned: " + totalMedals);
    }

    // checks if the user earned a medal
    public static void checkIfEarnedMedal(int totalMedals) {
        if (totalMedals > 0) {
            System.out.println("Congratulations! You have earned a medal in the Multi-Sports Championship.");
        } else {
            System.out.println("Sorry, you did not earn any medal in the Multi-Sports Championship.");
        }
    }

    // writes the results to an output file
    public static void writeToOutputFile(int totalMedals) {
        try {
            PrintWriter output = new PrintWriter(OUTPUT_FILE_NAME);

            output.println("Number of gold medals: " + medals.getGoldMedals());
            output.println("Number of silver medals: " + medals.getSilverMedals());
            output.println("Number of bronze medals: " + medals.getBronzeMedals());
            output.println("Total medals earned: " + totalMedals);

            if (totalMedals > 0) {
                output.println("Congratulations! You have earned a medal in the Multi-Sports Championship.");
            } else {
                output.println("Sorry, you did not earn any medal in the Multi-Sports Championship.");
            }

            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
    }
}

// MedalRecord class
class MedalRecord {
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;

    public MedalRecord(int goldMedals, int silverMedals, int bronzeMedals) {
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }

    // accessor methods
    public int getGoldMedals() {
        return goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }
}
