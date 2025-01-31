public class SimpleCountingSort {
    public static void countingSort(int[] ages) {
        // Create a count array to store the frequency of each age (from 10 to 18)
        int[] count = new int[9];

        // Store the frequency of each age in the count array
        for (int age : ages) {
            count[age - 10]++;
        }

        // Create an output array to store the sorted ages
        int[] output = new int[ages.length];
        int index = 0;

        // Place elements in their correct positions in the output array
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                output[index++] = i + 10;
                count[i]--;
            }
        }

        // Copy the sorted ages back to the original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        // Sample array of student ages
        int[] ages = {12, 14, 16, 11, 10, 13, 15, 18, 17, 12, 14, 13, 15};

        // Print the original array
        System.out.println("Original ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();

        // Perform counting sort on the ages
        countingSort(ages);

        // Print the sorted array
        System.out.println("Sorted ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
}
