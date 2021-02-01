import java.util.Arrays;

// calculate running time

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        // sanity check
        if (arr == null || arr.length == 0) return;

        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            // swap
            swap(arr, i, indexOfMin);
        }
    }

    // helper function to swap between elements at i and j
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 6, 7, 9, 10, 20, 7, 8, 2, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
