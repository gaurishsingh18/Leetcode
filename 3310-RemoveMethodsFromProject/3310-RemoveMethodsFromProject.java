// Last updated: 05/08/2026, 21:18:55
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3        List<Integer>[] graph = new ArrayList[n];
4        for (int i = 0; i < n; i++) {
5            graph[i] = new ArrayList<>();
6        }
7        for (int[] e : invocations) {
8            graph[e[0]].add(e[1]);
9        }
10        boolean[] suspicious = new boolean[n];
11        Deque<Integer> stack = new ArrayDeque<>();
12        stack.push(k);
13        suspicious[k] = true;
14        while (!stack.isEmpty()) {
15            int u = stack.pop();
16            for (int v : graph[u]) {
17                if (!suspicious[v]) {
18                    suspicious[v] = true;
19                    stack.push(v);
20                }
21            }
22        }
23        for (int[] e : invocations) {
24            if (!suspicious[e[0]] && suspicious[e[1]]) {
25                List<Integer> ans = new ArrayList<>();
26                for (int i = 0; i < n; i++) {
27                    ans.add(i);
28                }
29                return ans;
30            }
31        }
32        List<Integer> ans = new ArrayList<>();
33        for (int i = 0; i < n; i++) {
34            if (!suspicious[i]) {
35                ans.add(i);
36            }
37        }
38        return ans;
39    }
40}