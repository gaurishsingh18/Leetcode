// Last updated: 09/08/2026, 20:37:00
1class Solution {
2    public int[][] generateMatrix(int n) {
3        int[][] matrix = new int[n][n];
4        int top = 0, bottom = n - 1;
5        int left = 0, right = n - 1;
6        int num = 1;
7        while (top <= bottom && left <= right) {
8            for (int i = left; i <= right; i++) {
9                matrix[top][i] = num++;
10            }
11            top++;
12            for (int i = top; i <= bottom; i++) {
13                matrix[i][right] = num++;
14            }
15            right--;
16            if (top <= bottom) {
17                for (int i = right; i >= left; i--) {
18                    matrix[bottom][i] = num++;
19                }
20                bottom--;
21            }
22            if (left <= right) {
23                for (int i = bottom; i >= top; i--) {
24                    matrix[i][left] = num++;
25                }
26                left++;
27            }
28        }
29        return matrix;
30    }
31}