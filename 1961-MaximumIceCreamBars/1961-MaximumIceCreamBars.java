// Last updated: 25/06/2026, 23:08:53
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int max = 0;
        
        // Find maximum cost
        for (int cost : costs) {
            max = Math.max(max, cost);
        }
        int[] count = new int[max + 1];
        for (int cost : costs) {
            count[cost]++;
        }
        
        int bars = 0;
        for (int i = 1; i <= max; i++) {
            while (count[i] > 0 && coins >= i) {
                coins -= i;
                bars++;
                count[i]--;
            }
        }
        
        return bars;
    }
}