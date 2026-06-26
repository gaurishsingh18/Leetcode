// Last updated: 26/06/2026, 22:03:43
1class Solution {
2    public int minimumSum(int num) {
3        int[] arr = new int[4];
4        for (int i = 0; i < 4; i++) {
5            arr[i] = num % 10;
6            num /= 10;
7        }
8        Arrays.sort(arr);
9        int new1 = arr[0] * 10 + arr[2];
10        int new2 = arr[1] * 10 + arr[3];
11        return new1 + new2;
12    }
13}