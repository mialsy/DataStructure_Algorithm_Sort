public class QuickSort {
    public int[] sort(int[] arr) {
        // sanity check
        if (arr == null || arr.length <= 1) return arr;

        sort(arr, 0, arr.length - 1);

        return arr;
    }

    private void sort(int[] arr, int left, int right) {

    }
}
