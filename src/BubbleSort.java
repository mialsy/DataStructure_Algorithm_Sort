import java.util.Arrays;

// time: O(n^2)
// space: O(1)

public class BubbleSort {
    public static void sort(int[] arr) {

        // sanity check
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int pos = 0; pos < arr.length - 1; pos++) {
            // bubble from last to first
            for (int j = arr.length - 1; j > pos; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 6, 7, 9, 10, 20, 7, 8, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
