// Last updated: 01/07/2026, 21:25:46
class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        solve(nums, 0, 0);
        return sum;
    }
    public void solve(int[] nums, int index, int xor) {
        if (index == nums.length) {
            sum += xor;
            return;
        }
        solve(nums, index + 1, xor ^ nums[index]);
        solve(nums, index + 1, xor);
    }
}