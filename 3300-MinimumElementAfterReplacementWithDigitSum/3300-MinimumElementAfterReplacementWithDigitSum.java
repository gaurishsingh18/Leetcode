// Last updated: 26/06/2026, 14:22:09
1class Solution {
2    public int minElement(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        for (int num : nums) {
5            int sum = digitSum(num);
6            min = Math.min(min, sum);
7        }
8        return min;
9    }
10    public int digitSum(int num) {
11        int sum = 0;
12        while (num > 0) {
13            sum += num % 10;
14            num /= 10;
15        }
16        return sum;
17    }
18}