package KnapsackProblem;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Knapsack {

    // Method to solve the 0/1 Knapsack problem using dynamic programming
    public static void Knapsack(int[] itemWeights, int[] itemBenefits, int maxWeight) {
        int numberOfItems = itemWeights.length;
        int[][] dpTable = new int[numberOfItems + 1][maxWeight + 1];

        // Build the dynamic programming table
        for (int i = 1; i <= numberOfItems; i++) {
            for (int currentWeight = 0; currentWeight <= maxWeight; currentWeight++) {
                if (itemWeights[i - 1] <= currentWeight) {
                    dpTable[i][currentWeight] = Math.max(dpTable[i - 1][currentWeight],
                            itemBenefits[i - 1] + dpTable[i - 1][currentWeight - itemWeights[i - 1]]);
                } else {
                    dpTable[i][currentWeight] = dpTable[i - 1][currentWeight];
                }
            }
        }

        // method to Print the dynamic programming table
        System.out.println("Dynamic Programming Table:");
        for (int i = 0; i <= numberOfItems; i++) {
            for (int currentWeight = 0; currentWeight <= maxWeight; currentWeight++) {
                System.out.print(dpTable[i][currentWeight] + "\t");
            }
            System.out.println();
        }

        // Find the items to include in the knapsack for maximum value
        int remainingWeight = maxWeight;
        System.out.println("Items included in the knapsack for maximum benefit:");
        for (int i = numberOfItems; i > 0 && remainingWeight > 0; i--) {
            if (dpTable[i][remainingWeight] != dpTable[i - 1][remainingWeight]) {
                System.out.println("Item " + i + " (weight: " + itemWeights[i - 1] + ", benefit: " + itemBenefits[i - 1] + ")");
                remainingWeight -= itemWeights[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input the number of items
            System.out.print("\nEnter the number of items: ");
            int numberOfItems = scanner.nextInt();
            if (numberOfItems <= 0) {
                throw new IllegalArgumentException("The number of items must be positive.");
            }

            // Input the capacity of the knapsack
            System.out.print("Enter the max weight of the knapsack: ");
            int maxWeight = scanner.nextInt();
            if (maxWeight <= 0) {
                throw new IllegalArgumentException("The max weight of the knapsack must be positive.");
            }

            int[] itemWeights = new int[numberOfItems];
            int[] itemBenefits = new int[numberOfItems];

            // Input the weights and values of the items
            for (int i = 0; i < numberOfItems; i++) {
                System.out.print("Enter the weight of item " + (i + 1) + ": ");
                itemWeights[i] = scanner.nextInt();
                if (itemWeights[i] <= 0) {
                    throw new IllegalArgumentException("The weight of an item must be positive.");
                }

                System.out.print("Enter the benefit of item " + (i + 1) + ": ");
                itemBenefits[i] = scanner.nextInt();
                if (itemBenefits[i] <= 0) {
                    throw new IllegalArgumentException("The benefit of an item must be positive.");
                }
            }

            // Solve the 0/1 Knapsack problem
            Knapsack(itemWeights, itemBenefits, maxWeight);

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}

