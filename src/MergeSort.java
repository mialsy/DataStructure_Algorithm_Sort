import java.util.Arrays;

public class MergeSort {
    // divide and conquer
    public int[] sort(int[] arr) {
        // sanity check
        if (arr == null || arr.length <= 1) return arr;

        return sort(arr, 0, arr.length - 1);
    }

    private int[] merge(int[] arr1, int[] arr2) {
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

        int mid = (right - left) / 2 + left;
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
