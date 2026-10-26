// Last updated: 26/10/2026, 23:19:15
1class Solution {
2    public int countIslands(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        boolean[][] visited = new boolean[m][n];
6        int count = 0;
7        
8        int[] dr = {-1, 1, 0, 0};
9        int[] dc = {0, 0, -1, 1};
10        
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                if (grid[i][j] > 0 && !visited[i][j]) {
14                    long islandSum = 0;
15                    java.util.Queue<int[]> queue = new java.util.LinkedList<>();
16                    queue.offer(new int[]{i, j});
17                    visited[i][j] = true;
18                    
19                    while (!queue.isEmpty()) {
20                        int[] curr = queue.poll();
21                        int r = curr[0];
22                        int c = curr[1];
23                        islandSum += grid[r][c];
24                        
25                        for (int d = 0; d < 4; d++) {
26                            int nr = r + dr[d];
27                            int nc = c + dc[d];
28                            
29                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0 && !visited[nr][nc]) {
30                                visited[nr][nc] = true;
31                                queue.offer(new int[]{nr, nc});
32                            }
33                        }
34                    }
35                    
36                    if (islandSum % k == 0) {
37                        count++;
38                    }
39                }
40            }
41        }
42        
43        return count;
44    }
45}