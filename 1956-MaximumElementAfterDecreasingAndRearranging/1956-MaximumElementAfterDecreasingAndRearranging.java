// Last updated: 01/07/2026, 21:25:48
import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        // First element must be 1
        arr[0] = 1;

        // Adjust remaining elements
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        // Last element is the maximum possible
        return arr[arr.length - 1];
    }
}