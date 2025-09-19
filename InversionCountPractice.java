public class InversionCountPractice {

    // Main method that start the inversion counting
    public static int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Divide the array like merge sort and count inversions as we go
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions on the left half
            count += mergeSortAndCount(arr, left, mid);

            // Count inversions on the right half
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count inversions when merging left + right halves
            count += mergeAndCount(arr, left, mid, right);
        }

        return count; // total inversions in this section
    }

    // Merge two halves and count how many pairs are "out of order"
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];   // left side
        int[] rightArr = new int[right - mid];    // right side

        // Copy values into temporary arrays
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightArr.length; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left, inversions = 0;

        // Merge step: compare elements from both sides
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++]; // left is smaller, safe to place
            } else {
                arr[k++] = rightArr[j++]; // right is smaller → inversion!
                inversions += (mid + 1) - (left + i); // all remaining in leftArr are greater
            }
        }

        // Copy leftovers (already sorted, so no new inversions here)
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return inversions; // report inversions found in this merge
    }
}
