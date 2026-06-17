// Last updated: 17/06/2026, 22:05:36
1class Solution {
2    public int[] findDegrees(int[][] matrix) {
3        int n = matrix.length;
4        int[] ans = new int[n];
5        
6        // Loop through each vertex (row)
7        for (int i = 0; i < n; i++) {
8            int degree = 0;
9            // Sum up the connections in the current row
10            for (int j = 0; j < n; j++) {
11                degree += matrix[i][j];
12            }
13            ans[i] = degree;
14        }
15        
16        return ans;
17    }
18}