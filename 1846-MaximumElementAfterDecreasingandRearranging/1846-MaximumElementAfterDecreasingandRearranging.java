// Last updated: 28/06/2026, 22:15:14
1import java.util.Arrays;
2
3class Solution {
4    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
5        Arrays.sort(arr);
6
7        // First element must be 1
8        arr[0] = 1;
9
10        // Adjust remaining elements
11        for (int i = 1; i < arr.length; i++) {
12            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
13        }
14
15        // Last element is the maximum possible
16        return arr[arr.length - 1];
17    }
18}