// Last updated: 23/06/2026, 19:46:46
1class Solution {
2    public int maxArea(int[] height) {
3        int left = 0;
4        int right = height.length - 1;
5        int maxWater = 0;
6
7        while (left < right) {
8            int width = right - left;
9            int h = Math.min(height[left], height[right]);
10            int area = width * h;
11
12            if (area > maxWater) {
13                maxWater = area;
14            }
15
16            if (height[left] < height[right]) {
17                left++;
18            } else {
19                right--;
20            }
21        }
22
23        return maxWater;
24    }
25}