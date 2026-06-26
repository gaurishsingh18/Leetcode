// Last updated: 26/06/2026, 14:07:15
1class Solution {
2    public int differenceOfSums(int n, int m) {
3        int num1= 0;
4        int num2= 0;
5        for (int i=1; i<= n; i++){
6            if (i% m==0){
7                num2 += i;
8            } else {
9                num1 += i;
10            }
11        }
12        return num1-num2;
13    }
14}