package Day4;

public class SearchFirstNegative {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, 5};
        int index = findFirstNegative(arr);
        System.out.println("First negative number found at index: " + index);
    }

    private static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}

