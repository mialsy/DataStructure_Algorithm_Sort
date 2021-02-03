import java.util.Arrays;

public class InsertionSort {
    /*
    Summary:
        shift element right if it is larger than current
        replace element i + 1 if the element i is smaller than current
        replace the first element if the all sorted element is larger than the current element

     Time and space complexity analysis:
        worst case: array in reversed order
         1 + 2 + 3 + ... + n
         total time:  O(n^2)
         total space: O(1)
         stable

         base case: array already sorted
         O(n)

         use case => array almost sorted
     */


    public void sort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;
            // replace element i + 1 if the element i is smaller than current
            // replace the first element if the all sorted element is larger than the current element
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j]; //shift right by one pos
                j--;
            }
            arr[j + 1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = RandomArrayGenerator.generate(20, 100);
        System.out.println(Arrays.toString(arr));
        InsertionSort is = new InsertionSort();
        is.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
