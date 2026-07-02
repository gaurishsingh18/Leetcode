// Last updated: 02/07/2026, 22:36:55
1class Solution {
2    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
3        int m = grid.size();
4        int n = grid.get(0).size();
5        int[][] dist = new int[m][n];
6        for (int[] row : dist) {
7            Arrays.fill(row, Integer.MAX_VALUE);
8        }
9        Deque<int[]> dq= new  ArrayDeque<>();
10        dist[0][0] = grid.get(0).get(0);
11        dq.offerFirst(new int[]{0, 0});
12        int[][] dir =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
13        while (!dq.isEmpty()) {
14            int[] curr = dq.pollFirst();
15            int x= curr[0];
16            int y =  curr[1];
17            for (int[] d : dir) {
18                int nx = x+d[0];
19                int ny = y+d[1];
20                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
21                    int cost = grid.get(nx).get(ny);
22                    if (dist[x][y] + cost < dist[nx][ny]) {
23                        dist[nx][ny] = dist[x][y] + cost;
24                        if (cost == 0) {
25                            dq.offerFirst(new int[]{nx, ny});
26                        } else {
27                            dq.offerLast(new int[]{nx, ny});
28                        }
29                    }
30                }
31            }
32        }
33        return dist[m - 1][n - 1] < health;
34    }
35}