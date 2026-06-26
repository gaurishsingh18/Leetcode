// Last updated: 26/06/2026, 14:33:41
1class Solution {
2public int countDigits(int num) {
3int original=num;
4int count=0;
5while (num>0) {
6int digit=num%10;
7if (original%digit==0) {
8count++;
9}
10num/=10;
11}
12 return count;
13}
14}