// Last updated: 01/08/2026, 20:31:54
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4        if (n < 3) return n;
5        return 1 << (32 - Integer.numberOfLeadingZeros(n));
6    }
7}