// Last updated: 25/06/2026, 23:09:15
class Solution {
    public int removeElement(int[] nums, int val) {
       int k = 0;
       for (int i=0; i<nums.length; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
       } 
       return k;
    }
}