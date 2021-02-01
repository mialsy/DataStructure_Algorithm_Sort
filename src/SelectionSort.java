import java.util.Arrays;

/* calculate running time
*
* in inner loop
* i = 0 => n - 1
* i = 1 => n - 2
* ...
* i = n - 1 => 1
* i = n => 0
*
* Time complexity:
* Sum = n - 1 + n - 2 + ... + 2 + 1 + 0
*     = 1 + 2 + 3 + ... + n - 1
*     = (n - 1) * n / 2
*     = Theta(n ^ 2)
*
* Space complexity:
* heap: O(1)
* stack: O(1)
*
* */


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
