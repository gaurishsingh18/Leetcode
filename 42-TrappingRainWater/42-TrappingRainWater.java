// Last updated: 03/07/2026, 21:13:11
1class Solution {
2    public int trap(int[] height) {
3        int left = 0;
4        int right = height.length - 1;
5
6        int leftMax = 0;
7        int rightMax = 0;
8        int water = 0;
9
10        while (left < right) {
11            if (height[left] < height[right]) {
12                if (height[left] >= leftMax) {
13                    leftMax = height[left];
14                }else {
15                    water += leftMax - height[left];
16                }
17                left++;
18            }
19            else{
20                if (height[right] >= rightMax) {
21                    rightMax = height[right];
22                }else{
23                    water += rightMax - height[right];
24                }
25                right--;
26            }
27        }
28        return water;
29    }
30}