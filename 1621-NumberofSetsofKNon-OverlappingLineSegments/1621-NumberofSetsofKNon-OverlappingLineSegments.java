// Last updated: 16/09/2026, 23:23:26
1class Solution {
2    public int numberOfSets(int n, int k) {
3        long mod = 1000000007;
4        int N = n + k - 1;
5        int R = 2 * k;
6        if (R > N || R < 0) return 0;
7        long numerator = 1;
8        long denominator = 1;
9        for (int i = 0; i < R; i++) {
10            numerator = (numerator * (N - i)) % mod;
11            denominator = (denominator * (i + 1)) % mod;
12        }
13        long invDenominator = power(denominator, mod - 2, mod);
14        return (int) ((numerator * invDenominator) % mod);
15    }
16    private long power(long base, long exp, long mod) {
17        long res = 1;
18        base %= mod;
19        while (exp > 0) {
20            if ((exp & 1) == 1) res = (res * base) % mod;
21            base = (base * base) % mod;
22            exp >>= 1;
23        }
24        return res;
25    }
26}