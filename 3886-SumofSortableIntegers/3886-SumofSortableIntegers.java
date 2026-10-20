// Last updated: 20/10/2026, 23:07:58
1class Solution {
2    public int sortableIntegers(int[] nums) {
3        int n = nums.length;
4        int totalSum = 0;
5
6        for (int k = 1; k <= n; k++) {
7            if (n % k != 0) {
8                continue;
9            }
10
11            boolean ok = true;
12            int prevMax = Integer.MIN_VALUE;
13
14            for (int i = 0; i < n; i += k) {
15                int descents = 0;
16                int descentIdx = -1;
17
18                for (int j = 0; j < k; j++) {
19                    int curr = nums[i + j];
20                    int next = nums[i + (j + 1) % k];
21                    if (curr > next) {
22                        descents++;
23                        descentIdx = i + j;
24                    }
25                }
26
27                if (descents > 1) {
28                    ok = false;
29                    break;
30                }
31
32                int blockMin, blockMax;
33                if (descents == 0) {
34                    blockMin = nums[i];
35                    blockMax = nums[i + k - 1];
36                } else {
37                    int nextIdx = i + (descentIdx - i + 1) % k;
38                    blockMin = nums[nextIdx];
39                    blockMax = nums[descentIdx];
40                }
41
42                if (prevMax > blockMin) {
43                    ok = false;
44                    break;
45                }
46                prevMax = blockMax;
47            }
48
49            if (ok) {
50                totalSum += k;
51            }
52        }
53
54        return totalSum;
55    }
56}