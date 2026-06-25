// Last updated: 25/06/2026, 23:08:58
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int count = 0;
        for (int num : nums ) {
            count += freq[num];
            freq[num]++;
        }
        return count;
    }
}