// Last updated: 07/11/2026, 18:20:10
1import java.util.PriorityQueue;
2
3class Solution {
4    public int[] assignTasks(int[] servers, int[] tasks) {
5        int n = servers.length;
6        int m = tasks.length;
7        
8        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
9            if (a[0] != b[0]) {
10                return Integer.compare(a[0], b[0]);
11            }
12            return Integer.compare(a[1], b[1]);
13        });
14        
15        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
16            if (a[0] != b[0]) {
17                return Long.compare(a[0], b[0]);
18            }
19            if (a[1] != b[1]) {
20                return Long.compare(a[1], b[1]);
21            }
22            return Long.compare(a[2], b[2]);
23        });
24        
25        for (int i = 0; i < n; i++) {
26            freeServers.offer(new int[] { servers[i], i });
27        }
28        
29        int[] ans = new int[m];
30        long currentTime = 0;
31        
32        for (int j = 0; j < m; j++) {
33            currentTime = Math.max(currentTime, j);
34            
35            if (freeServers.isEmpty()) {
36                currentTime = busyServers.peek()[0];
37            }
38            
39            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
40                long[] busy = busyServers.poll();
41                freeServers.offer(new int[] { (int) busy[1], (int) busy[2] });
42            }
43            
44            int[] server = freeServers.poll();
45            int weight = server[0];
46            int index = server[1];
47            
48            ans[j] = index;
49            busyServers.offer(new long[] { currentTime + tasks[j], weight, index });
50        }
51        
52        return ans;
53    }
54}