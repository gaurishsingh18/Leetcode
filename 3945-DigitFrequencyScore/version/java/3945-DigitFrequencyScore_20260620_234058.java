// Last updated: 20/06/2026, 23:40:58
1class Solution {
2    public int digitFrequencyScore(int n) {
3       int score = 0;
4        while (n>0) {
5            int digit = n % 10;
6            score += digit;
7            n= n / 10;
8        } 
9        return score;
10    }
11}