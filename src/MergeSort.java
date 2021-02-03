import java.util.Arrays;

/*
Call stack would be like:
sort:
                [0, 1, 2, 3, 4, 5 ... n]                      -> 1 array sort
                /                      \
        [0,1, 2, ... n/2]        [n/2 + 1, n/2 + 2, ... n]    -> 2 arrays sort
         /       \                   /       \
       ...       ...              ...        ...              -> n/2 arrays sort
=> total time: 1 + 2 + 4 + ... + n/2 = ?
          ((1 + 1) + 2 + 4 + ... + n/2) - 1 = n - 1
          => O(n) time

merge:
       ...         ...              ...         ...           -> length: 1       n arrays
           \      /                   \          /
       [0,1, 2, ... n/2]        [n/2 + 1, n/2 + 2, ... n]     -> length: n/2     2 arrays
                   \                  /
                [0, 1, 2, 3, 4, 5 ... n]                      -> length: n       1 array
log n level, n operations at each level

=> total time: O(n * log(n))
=> total space: 1 + 2 + ... + n => O(n)
 */

public class MergeSort {
    // divide and conquer
    public int[] sort(int[] arr) {
        // sanity check
        if (arr == null || arr.length <= 1) return arr;

        return sort(arr, 0, arr.length - 1);
    }

    private int[] merge(int[] arr1, int[] arr2) {
        // inside merge, time = ?
        // -> depends on length total length
        // total length: arr1 length + arr 2 length
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            res[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            res[k++] = arr2[j++];
        }

        return res;
    }

    // sort half of original every time
    private int[] sort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left]};
        }

        int mid = (right - left) / 2 + left; // constant time
        int[] leftHalf = sort(arr, left, mid);
        int[] rightHalf = sort(arr, mid + 1, right);
        return merge(leftHalf, rightHalf);
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();

        int[] arr = RandomArrayGenerator.generate(20, 100);

        System.out.println(Arrays.toString(arr));

        arr = ms.sort(arr);

        System.out.println(Arrays.toString(arr));


    }


}
