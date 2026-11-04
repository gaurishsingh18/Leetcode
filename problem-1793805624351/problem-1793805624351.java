// Last updated: 04/11/2026, 20:50:24
1import java.util.PriorityQueue;
2import java.util.HashMap;
3import java.util.Map;
4import java.util.Arrays;
5
6class Solution {
7    private static class SlidingWindowMedian {
8        private final PriorityQueue<Long> maxHeap;
9        private final PriorityQueue<Long> minHeap;
10        private final Map<Long, Integer> delayedMax;
11        private final Map<Long, Integer> delayedMin;
12        private int maxHeapSize;
13        private int minHeapSize;
14        private long maxHeapSum;
15        private long minHeapSum;
16
17        public SlidingWindowMedian() {
18            maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
19            minHeap = new PriorityQueue<>();
20            delayedMax = new HashMap<>();
21            delayedMin = new HashMap<>();
22            maxHeapSize = 0;
23            minHeapSize = 0;
24            maxHeapSum = 0;
25            minHeapSum = 0;
26        }
27
28        public void insert(long num) {
29            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
30                maxHeap.offer(num);
31                maxHeapSum += num;
32                maxHeapSize++;
33            } else {
34                minHeap.offer(num);
35                minHeapSum += num;
36                minHeapSize++;
37            }
38            balance();
39        }
40
41        public void remove(long num) {
42            if (!maxHeap.isEmpty() && num <= maxHeap.peek()) {
43                delayedMax.put(num, delayedMax.getOrDefault(num, 0) + 1);
44                maxHeapSum -= num;
45                maxHeapSize--;
46            } else {
47                delayedMin.put(num, delayedMin.getOrDefault(num, 0) + 1);
48                minHeapSum -= num;
49                minHeapSize--;
50            }
51            balance();
52        }
53
54        private void balance() {
55            while (maxHeapSize > minHeapSize + 1) {
56                long num = maxHeap.poll();
57                maxHeapSum -= num;
58                maxHeapSize--;
59                minHeap.offer(num);
60                minHeapSum += num;
61                minHeapSize++;
62                prune();
63            }
64            while (minHeapSize > maxHeapSize) {
65                long num = minHeap.poll();
66                minHeapSum -= num;
67                minHeapSize--;
68                maxHeap.offer(num);
69                maxHeapSum += num;
70                maxHeapSize++;
71                prune();
72            }
73            prune();
74        }
75
76        private void prune() {
77            while (!maxHeap.isEmpty() && delayedMax.containsKey(maxHeap.peek())) {
78                long num = maxHeap.peek();
79                int count = delayedMax.get(num);
80                if (count == 1) {
81                    delayedMax.remove(num);
82                } else {
83                    delayedMax.put(num, count - 1);
84                }
85                maxHeap.poll();
86            }
87            while (!minHeap.isEmpty() && delayedMin.containsKey(minHeap.peek())) {
88                long num = minHeap.peek();
89                int count = delayedMin.get(num);
90                if (count == 1) {
91                    delayedMin.remove(num);
92                } else {
93                    delayedMin.put(num, count - 1);
94                }
95                minHeap.poll();
96            }
97        }
98
99        public long getCost() {
100            prune();
101            long median = maxHeap.peek();
102            long leftCost = maxHeapSize * median - maxHeapSum;
103            long rightCost = minHeapSum - minHeapSize * median;
104            return leftCost + rightCost;
105        }
106    }
107
108    public long minOperations(int[] nums, int x, int k) {
109        int n = nums.length;
110        long[] cost = new long[n - x + 1];
111        SlidingWindowMedian swm = new SlidingWindowMedian();
112
113        for (int i = 0; i < x; i++) {
114            swm.insert(nums[i]);
115        }
116        cost[0] = swm.getCost();
117
118        for (int i = x; i < n; i++) {
119            swm.remove(nums[i - x]);
120            swm.insert(nums[i]);
121            cost[i - x + 1] = swm.getCost();
122        }
123
124        long[][] dp = new long[k + 1][n + 2];
125        long inf = Long.MAX_VALUE / 2;
126
127        for (int j = 0; j <= k; j++) {
128            Arrays.fill(dp[j], inf);
129        }
130
131        for (int i = 0; i <= n; i++) {
132            dp[0][i] = 0;
133        }
134
135        for (int i = n; i >= 0; i--) {
136            for (int j = 1; j <= k; j++) {
137                long skip = (i + 1 <= n) ? dp[j][i + 1] : inf;
138                long pick = (i + x <= n && i <= n - x) ? cost[i] + dp[j - 1][i + x] : inf;
139                dp[j][i] = Math.min(skip, pick);
140            }
141        }
142
143        return dp[k][0];
144    }
145}