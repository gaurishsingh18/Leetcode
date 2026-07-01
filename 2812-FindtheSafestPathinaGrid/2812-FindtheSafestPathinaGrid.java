// Last updated: 01/07/2026, 16:14:52
1class Solution {
2    public int maximumSafenessFactor(List<List<Integer>> grid) {
3        int n = grid.size();
4        int[][] dist = new int[n][n];
5        for (int[] row : dist) Arrays.fill(row, -1);
6
7        Queue<int[]> q = new LinkedList<>();
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < n; j++) {
10                if (grid.get(i).get(j) == 1) {
11                    q.offer(new int[]{i, j});
12                    dist[i][j] = 0;
13                }
14            }
15        }
16        int[] dr = {-1, 1, 0, 0};
17        int[] dc = {0, 0, -1, 1};
18        while (!q.isEmpty()) {
19            int[] cur = q.poll();
20            int r = cur[0];
21            int c = cur[1];
22            for (int k = 0; k < 4; k++) {
23                int nr = r + dr[k];
24                int nc = c + dc[k];
25                if (nr >= 0 && nc >= 0 && nr < n && nc < n && dist[nr][nc] == -1) {
26                    dist[nr][nc] = dist[r][c] + 1;
27                    q.offer(new int[]{nr, nc});
28                }
29            }
30        }
31        int low = 0;
32        int high = 2 * n;
33        int ans = 0;
34        while (low <= high) {
35            int mid = low + (high - low) / 2;
36            if (canReach(dist, mid, n)) {
37                ans = mid;
38                low = mid + 1;
39            } else {
40                high = mid - 1;
41            }
42        }
43        return ans;
44    }
45    private boolean canReach(int[][] dist, int val, int n) {
46        if (dist[0][0] < val) return false;
47        Queue<int[]> q = new LinkedList<>();
48        boolean[][] visited = new boolean[n][n];
49        q.offer(new int[]{0, 0});
50        visited[0][0] = true;
51        int[] dr = {-1, 1, 0, 0};
52        int[] dc = {0, 0, -1, 1};
53        while (!q.isEmpty()) {
54            int[] cur = q.poll();
55            int r = cur[0];
56            int c = cur[1];
57            if (r == n - 1 && c == n - 1) return true;
58            for (int k = 0; k < 4; k++) {
59                int nr = r + dr[k];
60                int nc = c + dc[k];
61                if (nr >= 0 && nc >= 0 && nr < n && nc < n &&
62                    !visited[nr][nc] && dist[nr][nc] >= val) {
63                    visited[nr][nc] = true;
64                    q.offer(new int[]{nr, nc});
65                }
66            }
67        }
68        return false;
69    }
70}