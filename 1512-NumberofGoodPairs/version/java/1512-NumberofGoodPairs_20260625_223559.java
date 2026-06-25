// Last updated: 25/06/2026, 22:35:59
1class Solution {
2    public int numIdenticalPairs(int[] nums) {
3        int[] freq = new int[101];
4        int count = 0;
5        for (int num : nums ) {
6            count += freq[num];
7            freq[num]++;
8        }
9        return count;
10    }
11}