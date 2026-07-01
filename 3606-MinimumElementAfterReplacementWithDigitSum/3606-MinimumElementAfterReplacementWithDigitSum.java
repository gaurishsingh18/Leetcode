// Last updated: 01/07/2026, 21:25:08
class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int sum = digitSum(num);
            min = Math.min(min, sum);
        }
        return min;
    }
    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}