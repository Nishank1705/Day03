package Day5;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Arrays;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        int[] dataset = new int[1000000]; // Large dataset
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = (int) (Math.random() * 1000000); // Fill dataset with random values
        }

        int target = 999999; // Target to search for

        // Array (Linear Search)
        long startTime = System.nanoTime();
        boolean foundArray = linearSearch(dataset, target);
        long endTime = System.nanoTime();
        System.out.println("Array Search: " + (endTime - startTime) / 1e6 + " ms. Found: " + foundArray);

        // HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : dataset) {
            hashSet.add(value);
        }
        startTime = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("HashSet Search: " + (endTime - startTime) / 1e6 + " ms. Found: " + foundHashSet);

        // TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int value : dataset) {
            treeSet.add(value);
        }
        startTime = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search: " + (endTime - startTime) / 1e6 + " ms. Found: " + foundTreeSet);
    }

    public static boolean linearSearch(int[] data, int target) {
        for (int value : data) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
