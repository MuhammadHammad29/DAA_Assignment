package QuickSort;

public class QuickSort {

    // Method to perform quicksort on the array
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // Find the pivot index
            int pivotIndex = partition(array, startIndex, endIndex);

            // Recursively sort the elements before and after the partition
            quickSort(array, startIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, endIndex);
        }
    }

    // Method to partition the array
    public static int partition(int[] array, int startIndex, int endIndex) {
        int pivotValue = array[endIndex]; // Choose the last element as the pivot
        int i = startIndex - 1; // Index of the smaller element

        for (int j = startIndex; j < endIndex; j++) {
            // If the current element is smaller than or equal to the pivot
            if (array[j] <= pivotValue) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[endIndex] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[endIndex];
        array[endIndex] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Define the array to be sorted
        int[] data = {2, 8, 7, 1, 3, 5, 6, 4};

        // Print the original array
        System.out.println("\nOriginal array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Perform quicksort on the array
        quickSort(data, 0, data.length - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

