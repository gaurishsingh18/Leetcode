// Last updated: 03/07/2026, 21:21:35
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        Stack<Integer> stack = new Stack<>();
4        int maxArea = 0;
5        int n = heights.length;
6
7        for ( int i = 0; i <= n; i++) {
8            int currHeight = (i == n) ? 0 : heights[i];
9
10            while (!stack.isEmpty() && currHeight < heights[stack.peek()]){
11                int height = heights[stack.pop()];
12
13                int width;
14                if (stack.isEmpty()) {
15                    width = i;
16                }else{
17                    width = i - stack.peek()- 1;
18                }
19                maxArea = Math.max(maxArea, height * width);
20            }
21            stack.push(i);
22        }
23        return maxArea;
24    }
25}