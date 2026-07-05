// Last updated: 05/07/2026, 12:56:33
1class Solution {
2    public int[] pathsWithMaxScore(List<String> board) {
3        int n = board.size();
4        int MOD = 1_000_000_007;
5        int[][] score = new int[n][n];
6        int[][] ways = new int[n][n];
7        for (int i = 0; i < n; i++) {
8            Arrays.fill(score[i], -1);
9        }
10        score[n -1][n - 1] = 0;
11        ways[n - 1][n - 1] = 1;
12
13        for (int i = n -1; i>= 0; i--) {
14            for ( int j = n - 1; j>= 0; j--) {
15
16                if (board.get(i).charAt(j) == 'X')
17                continue;
18
19                if(i == n - 1 && j == n -1)
20                continue;
21
22                int best = -1;
23                long cnt = 0;
24
25                int [][] dir = {{1,0}, {0,1}, {1,1}};
26
27                for (int[] d : dir) {
28                    int ni = i + d[0];
29                    int nj = j + d[1];
30
31                    if(ni >= n || nj >= n)
32                    continue;
33
34                    if(score[ni][nj] == -1)
35                    continue;
36
37                    if (score[ni][nj] > best) {
38                        best = score[ni][nj];
39                        cnt = ways[ni][nj];
40                    }else if (score[ni][nj] == best) {
41                        cnt = (cnt + ways[ni][nj]) % MOD;
42                    }
43                }  
44                if (best == -1)
45                continue;
46
47                char ch = board.get(i).charAt(j);
48                int val = (Character.isDigit(ch)) ? ch - '0' : 0;
49
50                score[i][j] = best + val;
51                ways[i][j] = (int) (cnt % MOD);
52               } 
53            }
54            if (ways[0][0] == 0)
55            return new int[]{0, 0};
56            return new int[]{score[0][0], ways[0][0]};
57        }
58    }
59