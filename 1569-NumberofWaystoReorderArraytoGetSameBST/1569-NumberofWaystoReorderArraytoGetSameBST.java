// Last updated: 18/10/2026, 22:31:39
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    private static final long MOD = 1000000007;
6    private long[][] table;
7
8    public int numOfWays(int[] nums) {
9        int n = nums.length;
10        table = new long[n + 1][n + 1];
11        for (int i = 0; i <= n; i++) {
12            table[i][0] = 1;
13            for (int j = 1; j <= i; j++) {
14                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
15            }
16        }
17
18        List<Integer> list = new ArrayList<>();
19        for (int num : nums) {
20            list.add(num);
21        }
22
23        return (int) ((dfs(list) - 1 + MOD) % MOD);
24    }
25
26    private long dfs(List<Integer> nums) {
27        if (nums.size() <= 2) {
28            return 1;
29        }
30
31        int root = nums.get(0);
32        List<Integer> left = new ArrayList<>();
33        List<Integer> right = new ArrayList<>();
34
35        for (int i = 1; i < nums.size(); i++) {
36            if (nums.get(i) < root) {
37                left.add(nums.get(i));
38            } else {
39                right.add(nums.get(i));
40            }
41        }
42
43        long leftWays = dfs(left);
44        long rightWays = dfs(right);
45
46        int lSize = left.size();
47        int rSize = right.size();
48        long comb = table[lSize + rSize][lSize];
49
50        long ways = (comb * leftWays) % MOD;
51        ways = (ways * rightWays) % MOD;
52        return ways;
53    }
54}