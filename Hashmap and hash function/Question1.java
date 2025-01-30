import java.util.*;

class FindAllSubarraysWithZeroSum {
    public static void findSubarraysWithZeroSum(int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sum == 0) {
                result.add(new int[] {0, i});
            }

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[] {start + 1, i});
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        for (int[] subarray : result) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}
class Question1{
    public static void main(String[] args) {
        int[] array = {4, 2, -3, -1, 0, 4};
        FindAllSubarraysWithZeroSum.findSubarraysWithZeroSum(array);
    }
}
