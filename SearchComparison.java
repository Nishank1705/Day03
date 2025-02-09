package Day5;
//import java.util.Arrays;

public class SearchComparison {

    public static void main(String[] args) {
        int[] dataset = new int[1000000]; // Large dataset
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = i; // Fill dataset with sorted values
        }

        int target = 999999; // Target to search for

        // Linear Search
        long startTime = System.nanoTime();
        boolean foundLinear = linearSearch(dataset, target);
        long endTime = System.nanoTime();
        System.out.println("Linear Search: " + (endTime - startTime) + " ns. Found: " + foundLinear);

        // Binary Search (requires sorted data)
        startTime = System.nanoTime();
        boolean foundBinary = binarySearch(dataset, target);
        endTime = System.nanoTime();
        System.out.println("Binary Search: " + (endTime - startTime) + " ns. Found: " + foundBinary);
    }

    public static boolean linearSearch(int[] data, int target) {
        for (int value : data) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return true;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

