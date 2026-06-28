// Last updated: 28/06/2026, 22:18:46
1class Solution {
2    public int minTimeToVisitAllPoints(int[][] points) {
3        int time = 0;
4
5        for (int i = 1; i < points.length; i++) {
6            int dx = Math.abs(points[i][0] - points[i - 1][0]);
7            int dy = Math.abs(points[i][1] - points[i - 1][1]);
8
9            time += Math.max(dx, dy);
10        }
11
12        return time;
13    }
14}