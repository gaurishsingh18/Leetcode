// Last updated: 01/07/2026, 21:26:11
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit,price - minPrice);
        }
        return maxProfit;
        
    }
}