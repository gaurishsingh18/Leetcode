// Last updated: 14/06/2026, 21:52:03
class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num> 0) {
            if (num % 2 ==0) {
                num/= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }
}