// Last updated: 11/07/2026, 14:51:58
1class Solution {
2    List<Integer>[] graph;
3    boolean[] visited;
4
5    public int countCompleteComponents(int n, int[][] edges) {
6        graph = new ArrayList[n];
7
8        for (int i = 0; i < n; i++) {
9            graph[i] = new ArrayList<>();
10        }
11        for (int[] e : edges) {
12            graph[e[0]].add(e[1]);
13            graph[e[1]].add(e[0]);
14        }
15        visited = new boolean[n];
16        int answer = 0;
17
18        for (int i = 0; i < n; i++) {
19            if (!visited[i]) {
20                List<Integer> component = new ArrayList<>();
21                dfs(i, component);
22
23                int vertices = component.size();
24                boolean complete = true;
25
26                for (int node : component) {
27                    if (graph[node].size() != vertices - 1) {
28                        complete = false;
29                        break;
30                    }
31                }
32                if (complete) answer++;
33            }
34        }
35
36        return answer;
37    }
38
39    private void dfs(int node, List<Integer> component) {
40        visited[node] = true;
41        component.add(node);
42
43        for (int next : graph[node]) {
44            if (!visited[next]) {
45                dfs(next, component);
46            }
47        }
48    }
49}