// Last updated: 25/06/2026, 23:08:37
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1000000007;
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Base case: length = 2
        for (int i = 0; i < m; i++) {
            up[i] = i;               // values smaller than i
            down[i] = m - i - 1;    // values greater than i
        }

        // Build for length 3 to n
        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] prefixDown = new long[m];
            long[] suffixUp = new long[m];

            prefixDown[0] = down[0];
            for (int i = 1; i < m; i++) {
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
            }

            suffixUp[m - 1] = up[m - 1];
            for (int i = m - 2; i >= 0; i--) {
                suffixUp[i] = (suffixUp[i + 1] + up[i]) % MOD;
            }

            for (int i = 0; i < m; i++) {
                // need previous move = down, current move = up
                if (i > 0) {
                    newUp[i] = prefixDown[i - 1];
                }

                // need previous move = up, current move = down
                if (i < m - 1) {
                    newDown[i] = suffixUp[i + 1];
                }
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}