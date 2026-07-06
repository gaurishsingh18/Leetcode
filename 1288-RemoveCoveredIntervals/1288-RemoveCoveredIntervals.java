// Last updated: 06/07/2026, 10:42:34
1class Solution {
2    public int removeCoveredIntervals(int[][] intervals) {
3        Arrays.sort(intervals, (a,b) -> {
4            if (a[0] == b[0])
5            return b[1] - a[1];
6            return a[0] - b[0];
7        });
8        int count = 0;
9        int maxEnd = -1;
10
11        for (int[] interval : intervals) {
12            if (interval[1] > maxEnd) {
13                count++;
14                maxEnd = interval[1];
15            }
16        }
17        return count;
18    }
19}