// Last updated: 28/06/2026, 22:24:46
1class Solution {
2    public int pivotInteger(int n) {
3        int sum = n * (n + 1) / 2;
4        int root = (int) Math.sqrt(sum);
5
6        if (root * root == sum) {
7            return root;
8        }
9
10        return -1;
11    }
12}