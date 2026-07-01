// Last updated: 01/07/2026, 21:25:06
class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return 0;
        }
        return nums.length - 1;
    }
}