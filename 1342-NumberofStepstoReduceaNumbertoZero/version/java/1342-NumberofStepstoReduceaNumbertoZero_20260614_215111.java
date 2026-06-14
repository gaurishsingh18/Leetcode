// Last updated: 14/06/2026, 21:51:11
1class Solution {
2    public int numberOfSteps(int num) {
3        int steps = 0;
4        while (num> 0) {
5            if (num % 2 ==0) {
6                num/= 2;
7            } else {
8                num -= 1;
9            }
10            steps++;
11        }
12        return steps;
13    }
14}