//package Hashmap;
import java.util.*;

class CheckPairWithGivenSum {
    public static boolean hasPairWithSum(int[] array, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : array) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
    public class Question2{
    public static void main(String[] args) {
        int[] array = {10, 15, 3, 7};
        int target = 17;
        System.out.println(CheckPairWithGivenSum.hasPairWithSum(array, target)); // Output: true
    }
}

