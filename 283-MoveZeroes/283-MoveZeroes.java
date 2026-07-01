// Last updated: 01/07/2026, 21:26:12
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        // move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        // fill remaining with zeros
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}