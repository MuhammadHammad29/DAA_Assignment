package CoinChangingProblem;

public class CoinChange {

    // Method to find the minimum number of coins/notes required for the given amount
    public static void coinChange(int amount) {
        // Array of available denominations in Pakistani currency
        int[] denominations = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};

        // Array to store the number of each denomination
        int[] noOfEachDenominations = new int[denominations.length];

        // Iterate through each denomination
        for (int i = 0; i < denominations.length; i++) {
            // If the denomination is less than or equal to the amount
            if (denominations[i] <= amount) {
                // number of denominations required
                noOfEachDenominations[i] = amount / denominations[i];
                // Reduce the amount by the total value of the counted denominations
                amount = amount % denominations[i];
            }
        }

        // Print the result
        System.out.println("\nTotal Denominations that are required for Rs. 1988:");
        for (int i = 0; i < denominations.length; i++) {
            if (noOfEachDenominations[i] != 0) {
                System.out.println("Rs "+ denominations[i] + " x " + noOfEachDenominations[i]);
            }
        }
    }

    public static void main(String[] args) {
        int amount = 1988;
        coinChange(amount);
    }
}
