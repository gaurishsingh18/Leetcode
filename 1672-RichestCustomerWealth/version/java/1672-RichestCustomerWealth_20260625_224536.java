// Last updated: 25/06/2026, 22:45:36
1class Solution {
2    public int maximumWealth(int[][] accounts) {
3        int maxWealth = 0;
4        for (int i = 0; i< accounts.length; i++){
5            int sum = 0;
6            for (int j = 0; j < accounts[i].length; j++) {
7                sum += accounts[i][j];
8            }
9            maxWealth = Math.max(maxWealth, sum);
10        }
11        return maxWealth;
12    }
13}