// Last updated: 25/06/2026, 23:08:31
class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        
        // Loop through each vertex (row)
        for (int i = 0; i < n; i++) {
            int degree = 0;
            // Sum up the connections in the current row
            for (int j = 0; j < n; j++) {
                degree += matrix[i][j];
            }
            ans[i] = degree;
        }
        
        return ans;
    }
}