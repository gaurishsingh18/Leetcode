// Last updated: 21/06/2026, 10:42:17
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        
4        int max = 0;
5        
6        // Find maximum cost
7        for (int cost : costs) {
8            max = Math.max(max, cost);
9        }
10        int[] count = new int[max + 1];
11        for (int cost : costs) {
12            count[cost]++;
13        }
14        
15        int bars = 0;
16        for (int i = 1; i <= max; i++) {
17            while (count[i] > 0 && coins >= i) {
18                coins -= i;
19                bars++;
20                count[i]--;
21            }
22        }
23        
24        return bars;
25    }
26}