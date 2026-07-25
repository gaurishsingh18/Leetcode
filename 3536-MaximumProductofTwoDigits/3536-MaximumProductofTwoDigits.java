// Last updated: 25/07/2026, 22:13:44
1class Solution {
2    public int maxProduct(int n) {
3        int[] cnt = new int[10];
4
5        while (n > 0) {
6            cnt[n % 10]++;
7            n /= 10;
8        }
9
10        for (int i = 9; i >= 0; i--) {
11            if (cnt[i] >= 2) return i * i;
12            for (int j = i - 1; j >= 0; j--) {
13                if (cnt[i] > 0 && cnt[j] > 0) {
14                    return i * j;
15                }
16            }
17        }
18
19        return 0;
20    }
21}