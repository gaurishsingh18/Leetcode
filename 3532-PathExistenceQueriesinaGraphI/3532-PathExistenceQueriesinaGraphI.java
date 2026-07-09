// Last updated: 09/07/2026, 12:35:16
1class Solution {
2    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3        int[] component = new int[n];
4        int comp = 0;
5        component[0] =comp;
6
7        for (int i = 1; i < n; i++) {
8            if (nums[i] - nums[i - 1] > maxDiff) {
9                comp++;
10            }
11            component[i] = comp;
12        }
13        boolean[] answer = new boolean[queries.length];
14        for(int i = 0; i < queries.length; i++) {
15            int u = queries[i][0];
16            int v = queries[i][1];
17            answer[i] = component[u] == component[v];
18        }
19        return answer;
20    }
21}