// Last updated: 09/11/2026, 19:39:24
1class Solution {
2    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
3        int[] requestCount = new int[k];
4        TreeSet<Integer> available = new TreeSet<>();
5        for (int i = 0; i < k; i++) {
6            available.add(i);
7        }
8        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
9        int maxRequests = 0;
10        for (int i = 0; i < arrival.length; i++) {
11            int currTime = arrival[i];
12            int duration = load[i];
13
14            while (!busy.isEmpty() && busy.peek()[0] <= currTime) {
15                available.add(busy.poll()[1]);
16            }
17            if (available.isEmpty()) {
18                continue;
19            }
20            Integer serverId = available.ceiling(i % k);
21            if (serverId == null) {
22                serverId = available.first();
23            }
24            available.remove(serverId);
25            busy.offer(new int[] {currTime + duration, serverId});
26            requestCount[serverId]++;
27            maxRequests = Math.max(maxRequests, requestCount[serverId]);
28        }
29        List<Integer> result = new ArrayList<>();
30        for (int i = 0; i < k; i++) {
31            if (requestCount[i] == maxRequests) {
32                result.add(i);
33            }
34        }
35        return result;
36    }
37}