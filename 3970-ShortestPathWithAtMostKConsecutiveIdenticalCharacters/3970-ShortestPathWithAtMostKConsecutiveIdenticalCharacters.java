// Last updated: 30/10/2026, 15:37:47
1import java.util.*;
2
3class Solution {
4    public int shortestPath(int n, int[][] edges, String labels, int k) {
5        List<int[]>[] graph = new ArrayList[n];
6        for (int i = 0; i < n; i++) {
7            graph[i] = new ArrayList<>();
8        }
9        for (int[] edge : edges) {
10            graph[edge[0]].add(new int[]{edge[1], edge[2]});
11        }
12
13        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
14        Map<Long, Integer> dist = new HashMap<>();
15
16        char startChar = labels.charAt(0);
17        long startState = getStateKey(0, 1, startChar);
18        pq.offer(new long[]{0, 0, 1, startChar});
19        dist.put(startState, 0);
20
21        while (!pq.isEmpty()) {
22            long[] curr = pq.poll();
23            long d = curr[0];
24            int u = (int) curr[1];
25            int count = (int) curr[2];
26            char lastChar = (char) curr[3];
27
28            if (u == n - 1) {
29                return (int) d;
30            }
31
32            long stateKey = getStateKey(u, count, lastChar);
33            if (d > dist.getOrDefault(stateKey, Integer.MAX_VALUE)) {
34                continue;
35            }
36
37            for (int[] edge : graph[u]) {
38                int v = edge[0];
39                int weight = edge[1];
40                char nextChar = labels.charAt(v);
41
42                int nextCount = (nextChar == lastChar) ? count + 1 : 1;
43                if (nextCount > k) {
44                    continue;
45                }
46
47                long nextStateKey = getStateKey(v, nextCount, nextChar);
48                int nextDist = (int) d + weight;
49
50                if (nextDist < dist.getOrDefault(nextStateKey, Integer.MAX_VALUE)) {
51                    dist.put(nextStateKey, nextDist);
52                    pq.offer(new long[]{nextDist, v, nextCount, nextChar});
53                }
54            }
55        }
56
57        return -1;
58    }
59
60    private long getStateKey(int u, int count, char ch) {
61        return ((long) u << 20) | ((long) count << 10) | (ch - 'a');
62    }
63}