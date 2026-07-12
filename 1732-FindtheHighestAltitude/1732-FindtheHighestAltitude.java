// Last updated: 12/07/2026, 15:33:15
1class Solution {
2    public int largestAltitude(int[] gain) {
3      int altitude = 0;
4        int maxAltitude = 0;
5        for (int g : gain) {
6            altitude += g;
7            maxAltitude = Math.max(maxAltitude, altitude);
8        }
9        return maxAltitude;   
10    }
11}