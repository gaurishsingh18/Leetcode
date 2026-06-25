// Last updated: 25/06/2026, 23:08:29
class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int reverse = 0;
        while (n>0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n/10;
        }
        return Math.abs(original - reverse);
        
    }
}