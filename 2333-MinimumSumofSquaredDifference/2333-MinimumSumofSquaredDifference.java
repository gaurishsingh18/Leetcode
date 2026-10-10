// Last updated: 10/10/2026, 22:48:57
1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        int n = nums1.length;
4        long totalK = (long) k1 + (long) k2;
5        
6        int[] count = new int[100001];
7        long maxDiff = 0;
8        
9        for (int i = 0; i < n; i++) {
10            int diff = Math.abs(nums1[i] - nums2[i]);
11            count[diff]++;
12            if (diff > maxDiff) {
13                maxDiff = diff;
14            }
15        }
16        
17        for (long d = maxDiff; d > 0 && totalK > 0; d--) {
18            if (count[(int) d] == 0) continue;
19            
20            long take = Math.min(totalK, count[(int) d]);
21            count[(int) d] -= take;
22            count[(int) d - 1] += (int) take;
23            totalK -= take;
24        }
25        
26        if (totalK > 0) {
27            return 0;
28        }
29        
30        long result = 0;
31        for (int i = 1; i <= maxDiff; i++) {
32            if (count[i] > 0) {
33                long val = i;
34                result += val * val * count[i];
35            }
36        }
37        return result;
38    }
39}