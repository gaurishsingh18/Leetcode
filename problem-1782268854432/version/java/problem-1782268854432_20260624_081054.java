// Last updated: 24/06/2026, 08:10:54
1class Solution {
2    
3    static final long MOD = 1000000007L;
4
5    public int zigZagArrays(int n, int l, int r) {
6        int m = r - l + 1;
7        int size = 2 * m;
8
9        if (n == 1) return m;
10
11        long[][] trans = new long[size][size];
12
13        for (int i = 0; i < m; i++) {
14
15            for (int j = i + 1; j < m; j++) {
16                trans[j][m + i] = 1;
17            }
18
19            for (int j = 0; j < i; j++) {
20                trans[m + j][i] = 1;
21            }
22        }
23
24        long[] base = new long[size];
25
26        for (int i = 0; i < m; i++) {
27            base[i] = i;
28            base[m + i] = m - i - 1;
29        }
30
31        if (n == 2) {
32            long ans = 0;
33            for (long x : base) ans = (ans + x) % MOD;
34            return (int) ans;
35        }
36
37        long[][] power = matrixPower(trans, n - 2);
38
39        long ans = 0;
40
41        for (int i = 0; i < size; i++) {
42            long ways = 0;
43            for (int j = 0; j < size; j++) {
44                ways = (ways + power[i][j] * base[j]) % MOD;
45            }
46            ans = (ans + ways) % MOD;
47        }
48
49        return (int) ans;
50    }
51
52    private long[][] matrixMultiply(long[][] a, long[][] b) {
53        int n = a.length;
54        long[][] res = new long[n][n];
55
56        for (int i = 0; i < n; i++) {
57            for (int k = 0; k < n; k++) {
58                if (a[i][k] == 0) continue;
59                for (int j = 0; j < n; j++) {
60                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
61                }
62            }
63        }
64        return res;
65    }
66
67    private long[][] matrixPower(long[][] mat, long exp) {
68        int n = mat.length;
69        long[][] res = new long[n][n];
70
71        for (int i = 0; i < n; i++) {
72            res[i][i] = 1;
73        }
74
75        while (exp > 0) {
76            if ((exp & 1) == 1) {
77                res = matrixMultiply(res, mat);
78            }
79            mat = matrixMultiply(mat, mat);
80            exp >>= 1;
81        }
82
83        return res;
84    }
85}