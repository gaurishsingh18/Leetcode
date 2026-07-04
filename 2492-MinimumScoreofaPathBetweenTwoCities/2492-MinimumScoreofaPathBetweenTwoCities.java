// Last updated: 04/07/2026, 20:31:42
1class Solution {
2    public int minScore(int n, int[][] roads) {
3        List<int[]>[] graph = new ArrayList[n + 1];
4        for (int i = 0; i <= n; i++) {
5            graph[i] = new ArrayList<>();
6        }
7
8        for (int[]road : roads) {
9            int u = road[0];
10            int v = road[1];
11            int d = road[2];
12
13            graph[u].add(new int[]{v, d});
14            graph[v].add(new int[]{u, d});
15
16        }
17        boolean[] visited = new boolean [ n + 1];
18        int[] ans = {Integer.MAX_VALUE};
19        dfs(1, graph, visited, ans);
20        return ans[0];
21    }
22    private void dfs(int node, List<int[]>[] graph, boolean[] visited, int[] ans) {
23        visited[node] = true;
24
25        for (int[] edge : graph[node]) {
26            int next = edge[0];
27            int dist = edge[1];
28
29            ans[0] = Math.min(ans[0], dist);
30
31            if ( !visited[next]) {
32                dfs(next, graph, visited, ans);
33            }
34        }
35    }
36}