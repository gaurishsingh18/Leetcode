// Last updated: 01/07/2026, 21:25:13
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int rem = num % 3;
            count += Math.min(rem, 3 - rem);
        }
        return count;
    }
}