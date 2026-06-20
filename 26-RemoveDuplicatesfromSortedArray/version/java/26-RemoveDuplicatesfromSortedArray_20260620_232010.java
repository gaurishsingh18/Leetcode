// Last updated: 20/06/2026, 23:20:10
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int k = 1; 
4        
5        for(int i=1; i< nums.length; i++){
6            if (nums[i] != nums[i-1]){
7                nums[k] = nums[i];
8               k++;
9            }
10        }
11        return k;
12    }
13}