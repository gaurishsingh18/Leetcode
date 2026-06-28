// Last updated: 28/06/2026, 22:23:17
1class Solution {
2    public int sumOddLengthSubarrays(int[] arr) {
3        int n = arr.length;
4        int sum = 0;
5        for (int i = 0; i < n; i++) {
6            int total = (i + 1) * (n - i);
7            int oddCount = (total + 1) / 2;
8            sum += arr[i] * oddCount;
9        }
10        return sum;
11    }
12}