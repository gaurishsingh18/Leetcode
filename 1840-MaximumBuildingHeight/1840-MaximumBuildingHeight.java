// Last updated: 05/07/2026, 13:05:27
1class Solution {
2    public int maxBuilding(int n, int[][] restrictions) {
3
4        List<int[]> list = new ArrayList<>();
5
6        list.add(new int[]{1, 0});
7
8        for (int[] r : restrictions)
9            list.add(new int[]{r[0], r[1]});
10
11        boolean hasLast = false;
12        for (int[] r : restrictions) {
13            if (r[0] == n) {
14                hasLast = true;
15                break;
16            }
17        }
18
19        if (!hasLast)
20            list.add(new int[]{n, n - 1});
21
22        Collections.sort(list, (a, b) -> a[0] - b[0]);
23
24        // Left -> Right
25        for (int i = 1; i < list.size(); i++) {
26            int d = list.get(i)[0] - list.get(i - 1)[0];
27            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i - 1)[1] + d);
28        }
29
30        // Right -> Left
31        for (int i = list.size() - 2; i >= 0; i--) {
32            int d = list.get(i + 1)[0] - list.get(i)[0];
33            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i + 1)[1] + d);
34        }
35
36        int ans = 0;
37
38        for (int i = 1; i < list.size(); i++) {
39            int x1 = list.get(i - 1)[0];
40            int h1 = list.get(i - 1)[1];
41
42            int x2 = list.get(i)[0];
43            int h2 = list.get(i)[1];
44
45            int d = x2 - x1;
46
47            ans = Math.max(ans, (h1 + h2 + d) / 2);
48        }
49
50        return ans;
51    }
52}