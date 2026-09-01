// Last updated: 01/09/2026, 19:39:26
1import java.util.Arrays;
2
3class Solution {
4    public int minMoves(String[] classroom, int energy) {
5        int m = classroom.length;
6        int n = classroom[0].length();
7        int[][] lIndex = new int[m][n];
8        int lCount = 0;
9        int startR = -1, startC = -1;
10
11        for (int i = 0; i < m; i++) {
12            Arrays.fill(lIndex[i], -1);
13            for (int j = 0; j < n; j++) {
14                char c = classroom[i].charAt(j);
15                if (c == 'S') {
16                    startR = i;
17                    startC = j;
18                } else if (c == 'L') {
19                    lIndex[i][j] = lCount++;
20                }
21            }
22        }
23
24        int targetMask = (1 << lCount) - 1;
25        if (targetMask == 0) return 0;
26
27        int[][][] visited = new int[m][n][1 << lCount];
28        for (int i = 0; i < m; i++) {
29            for (int j = 0; j < n; j++) {
30                Arrays.fill(visited[i][j], -1);
31            }
32        }
33
34        int capacity = 1 << 22; 
35        int maskCap = capacity - 1;
36        int[] q = new int[capacity];
37        int head = 0, tail = 0;
38
39        visited[startR][startC][0] = energy;
40        q[tail & maskCap] = (startR << 21) | (startC << 16) | (0 << 6) | energy;
41        tail++;
42
43        int steps = 0;
44        int[] dr = {-1, 1, 0, 0};
45        int[] dc = {0, 0, -1, 1};
46
47        while (head < tail) {
48            int size = tail - head;
49            
50            for (int i = 0; i < size; i++) {
51                int curr = q[head & maskCap];
52                head++;
53
54                int r = (curr >> 21) & 31;
55                int c = (curr >> 16) & 31;
56                int mask = (curr >> 6) & 1023;
57                int e = curr & 63;
58
59                if (e == 0) continue;
60
61                for (int d = 0; d < 4; d++) {
62                    int nr = r + dr[d];
63                    int nc = c + dc[d];
64
65                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
66                    char cell = classroom[nr].charAt(nc);
67                    if (cell == 'X') continue;
68
69                    int ne = e - 1;
70                    int nmask = mask;
71
72                    if (cell == 'R') {
73                        ne = energy;
74                    } else if (cell == 'L') {
75                        nmask |= (1 << lIndex[nr][nc]);
76                    }
77
78                    if (nmask == targetMask) {
79                        return steps + 1;
80                    }
81
82                    if (ne > visited[nr][nc][nmask]) {
83                        visited[nr][nc][nmask] = ne;
84                        q[tail & maskCap] = (nr << 21) | (nc << 16) | (nmask << 6) | ne;
85                        tail++;
86                    }
87                }
88            }
89            steps++;
90        }
91        return -1;
92    }
93}