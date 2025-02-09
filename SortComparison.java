package Day5;
import java.util.Arrays;

public class SortComparison {

    public static void main(String[] args) {
        int[] dataset = new int[10000]; // Large dataset
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = (int) (Math.random() * 10000); // Fill dataset with random values
        }

        // Bubble Sort
        int[] bubbleSortedData = Arrays.copyOf(dataset, dataset.length);
        long startTime = System.nanoTime();
        bubbleSort(bubbleSortedData);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort: " + (endTime - startTime) + " ns");

        // Merge Sort
        int[] mergeSortedData = Arrays.copyOf(dataset, dataset.length);
        startTime = System.nanoTime();
        mergeSort(mergeSortedData, 0, mergeSortedData.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort: " + (endTime - startTime) + " ns");

        // Quick Sort
        int[] quickSortedData = Arrays.copyOf(dataset, dataset.length);
        startTime = System.nanoTime();
        quickSort(quickSortedData, 0, quickSortedData.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort: " + (endTime - startTime) + " ns");
    }

    public static void bubbleSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    public static void merge(int[] data, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = data[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = data[mid + 1 + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                data[k] = leftArray[i];
                i++;
            } else {
                data[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            data[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            data[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    public static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }
}
