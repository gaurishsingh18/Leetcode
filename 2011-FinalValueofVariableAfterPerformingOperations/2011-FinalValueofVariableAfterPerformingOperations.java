// Last updated: 01/07/2026, 21:13:28
1class Solution {
2    public int finalValueAfterOperations(String[] operations) {
3        int x = 0;
4        for (String op : operations) {
5            if (op.charAt(1) == '+') {
6                x++;
7            }else{
8                x--;
9            }
10        }
11        return x;
12    }
13}