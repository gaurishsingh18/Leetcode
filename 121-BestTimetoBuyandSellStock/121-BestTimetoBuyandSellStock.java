// Last updated: 26/06/2026, 13:35:28
1class Solution {
2    public int maxProfit(int[] prices) {
3        int minPrice = Integer.MAX_VALUE;
4        int maxProfit = 0;
5        for(int price : prices) {
6            minPrice = Math.min(minPrice, price);
7            maxProfit = Math.max(maxProfit,price - minPrice);
8        }
9        return maxProfit;
10        
11    }
12}