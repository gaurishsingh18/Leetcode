// Last updated: 29/07/2026, 21:28:41
1class Solution {
2    static final long CAP = 1_000_000L;
3    public String smallestPalindrome(String s, int k) {
4        int[] freq = new int[26];
5        for (char ch : s.toCharArray()) freq[ch - 'a']++;
6
7        int[] half = new int[26];
8        String mid = "";
9        int halfLen = 0;
10
11        for (int i = 0; i < 26; i++) {
12            half[i] = freq[i] / 2;
13            halfLen += half[i];
14            if ((freq[i] & 1) == 1) mid = String.valueOf((char) ('a' + i));
15        }
16
17        if (countWays(half) < k) return "";
18
19        StringBuilder left = new StringBuilder();
20
21        for (int pos = 0; pos < halfLen; pos++) {
22            for (int c = 0; c < 26; c++) {
23                if (half[c] == 0) continue;
24
25                half[c]--;
26                long ways = countWays(half);
27
28                if (ways >= k) {
29                    left.append((char) ('a' + c));
30                    break;
31                } else {
32                    k -= ways;
33                    half[c]++;
34                }
35            }
36        }
37
38        StringBuilder right = new StringBuilder(left).reverse();
39        return left.toString() + mid + right.toString();
40    }
41
42    private long countWays(int[] cnt) {
43        int rem = 0;
44        for (int x : cnt) rem += x;
45
46        long ans = 1;
47
48        for (int c : cnt) {
49            if (c == 0) continue;
50            long ways = combCap(rem, c);
51            ans *= ways;
52            if (ans > CAP) return CAP + 1;
53            rem -= c;
54        }
55
56        return ans;
57    }
58
59    private long combCap(int n, int r) {
60        if (r < 0 || r > n) return 0;
61        r = Math.min(r, n - r);
62
63        long res = 1;
64
65        for (int i = 1; i <= r; i++) {
66            long a = n - r + i;
67            long b = i;
68
69            long g = gcd(a, b);
70            a /= g;
71            b /= g;
72
73            g = gcd(res, b);
74            res /= g;
75            b /= g;
76
77            res *= a;
78            res /= b;
79
80            if (res > CAP) return CAP + 1;
81        }
82
83        return res;
84    }
85
86    private long gcd(long a, long b) {
87        while (b != 0) {
88            long t = a % b;
89            a = b;
90            b = t;
91        }
92        return a;
93    }
94}