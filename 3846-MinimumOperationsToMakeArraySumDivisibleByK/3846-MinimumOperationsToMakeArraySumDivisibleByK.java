// Last updated: 01/07/2026, 21:25:02
class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum%k;
    }
}