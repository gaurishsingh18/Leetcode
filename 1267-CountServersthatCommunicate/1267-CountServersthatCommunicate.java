// Last updated: 08/11/2026, 22:17:34
1class Solution {
2    public int countServers(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int[] rowCounts = new int[m];
6        int[] colCounts = new int[n];
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (grid[i][j] == 1) {
10                    rowCounts[i]++;
11                    colCounts[j]++;
12                }
13            }
14        }
15        int communicatingServers = 0;
16        for (int i = 0; i < m; i++) {
17            for (int j = 0; j < n; j++) {
18                if (grid[i][j] == 1 && (rowCounts[i] > 1 || colCounts[j] > 1)) {
19                    communicatingServers++;
20                }
21            }
22        }
23        return communicatingServers;
24    }
25}