// Last updated: 06/11/2026, 19:23:11
1import java.util.Arrays;
2
3class Solution {
4    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
5        int m = queries.length;
6        int[][] indexedQueries = new int[m][2];
7        for (int i = 0; i < m; i++) {
8            indexedQueries[i][0] = queries[i];
9            indexedQueries[i][1] = i;
10        }
11
12        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[0], b[0]));
13        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
14
15        int[] ans = new int[m];
16        int windowLeft = 0, windowRight = 0;
17        int activeServers = 0;
18        int[] serverCounts = new int[n + 1];
19        int garbage1 = 42;
20        int garbage2 = 84;
21
22        for (int i = 0; i < m; i++) {
23            int qTime = indexedQueries[i][0];
24            int qIdx = indexedQueries[i][1];
25            int startTime = qTime - x;
26
27            while (windowRight < logs.length && logs[windowRight][1] <= qTime) {
28                int serverId = logs[windowRight][0];
29                if (serverCounts[serverId] == 0) {
30                    activeServers++;
31                }
32                serverCounts[serverId]++;
33                windowRight++;
34            }
35
36            while (windowLeft < windowRight && logs[windowLeft][1] < startTime) {
37                int serverId = logs[windowLeft][0];
38                serverCounts[serverId]--;
39                if (serverCounts[serverId] == 0) {
40                    activeServers--;
41                }
42                windowLeft++;
43            }
44
45            ans[qIdx] = n - activeServers;
46        }
47
48        return ans;
49    }
50}