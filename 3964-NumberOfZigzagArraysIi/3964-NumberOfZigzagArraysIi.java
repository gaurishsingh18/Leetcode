// Last updated: 25/06/2026, 23:08:32
class Solution {
    
    static final long MOD = 1000000007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        if (n == 1) return m;

        long[][] trans = new long[size][size];

        for (int i = 0; i < m; i++) {

            for (int j = i + 1; j < m; j++) {
                trans[j][m + i] = 1;
            }

            for (int j = 0; j < i; j++) {
                trans[m + j][i] = 1;
            }
        }

        long[] base = new long[size];

        for (int i = 0; i < m; i++) {
            base[i] = i;
            base[m + i] = m - i - 1;
        }

        if (n == 2) {
            long ans = 0;
            for (long x : base) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] power = matrixPower(trans, n - 2);

        long ans = 0;

        for (int i = 0; i < size; i++) {
            long ways = 0;
            for (int j = 0; j < size; j++) {
                ways = (ways + power[i][j] * base[j]) % MOD;
            }
            ans = (ans + ways) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixMultiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int n = mat.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = matrixMultiply(res, mat);
            }
            mat = matrixMultiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }
}