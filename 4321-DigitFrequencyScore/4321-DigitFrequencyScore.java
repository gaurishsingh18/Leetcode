// Last updated: 25/06/2026, 23:08:27
class Solution {
    public int digitFrequencyScore(int n) {
       int score = 0;
        while (n>0) {
            int digit = n % 10;
            score += digit;
            n= n / 10;
        } 
        return score;
    }
}