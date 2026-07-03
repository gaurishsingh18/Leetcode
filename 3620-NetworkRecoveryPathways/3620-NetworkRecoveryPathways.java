// Last updated: 03/07/2026, 21:00:10
1class Solution {
2    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
3        int n = online.length;
4        List<int[]>[] graph = new ArrayList[n];
5        int[] indegree = new int[n];
6        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
7        int low = Integer.MAX_VALUE, high = 0;
8        for (int[] e : edges) {
9            int u = e[0], v = e[1], c = e[2];
10            graph[u].add(new int[]{v, c});
11            indegree[v]++;
12            low = Math.min(low, c);
13            high = Math.max(high, c);
14        }
15        int[] topo = new int[n];
16        Queue<Integer> q = new LinkedList<>();
17        int[] tempIndegree = indegree.clone();
18        for (int i = 0; i < n; i++) {
19            if (tempIndegree[i] == 0) q.offer(i);
20        }
21        int idx = 0;
22        while (!q.isEmpty()) {
23            int u = q.poll();
24            topo[idx++] = u;
25            for (int[] nei : graph[u]) {
26                int v = nei[0];
27                if (--tempIndegree[v] == 0) q.offer(v);
28            }
29        }
30        int ans = -1;
31        while (low <= high) {
32            int mid = low + (high - low) / 2;
33            if (canReach(graph, topo, online, k, mid, n)) {
34                ans = mid;
35                low = mid + 1;
36            } else {
37                high = mid - 1;
38            }
39        }
40        return ans;
41    }
42    private boolean canReach(List<int[]>[] graph, int[] topo,
43                             boolean[] online, long k, int minEdge, int n) {
44        long INF = Long.MAX_VALUE;
45        long[] dist = new long[n];
46        Arrays.fill(dist, INF);
47        dist[0] = 0;
48        for (int u : topo) {
49            if (dist[u] == INF) continue;
50            if (u != 0 && u != n - 1 && !online[u]) continue;
51            for (int[] edge : graph[u]) {
52                int v = edge[0];
53                int cost = edge[1];
54                if (cost < minEdge) continue;
55                if (v != n - 1 && !online[v]) continue;
56                dist[v] = Math.min(dist[v], dist[u] + cost);
57            }
58        }
59        return dist[n - 1] <= k;
60    }
61}