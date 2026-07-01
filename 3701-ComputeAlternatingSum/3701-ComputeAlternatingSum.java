// Last updated: 01/07/2026, 21:09:56
1class Solution {
2    public int alternatingSum(int[] nums) {
3        int sum = 0;
4        for (int i =0; i< nums.length; i++){
5            if (i % 2 ==0){
6                sum+= nums[i];
7            }else {
8                sum -= nums[i];
9            }
10        }
11        return sum;
12    }
13}