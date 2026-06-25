// Last updated: 25/06/2026, 23:08:56
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i< accounts.length; i++){
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sum);
        }
        return maxWealth;
    }
}