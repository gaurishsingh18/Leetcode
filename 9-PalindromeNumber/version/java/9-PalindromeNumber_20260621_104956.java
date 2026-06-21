// Last updated: 21/06/2026, 10:49:56
1class Solution {
2    public boolean isPalindrome(int x) {
3        if (x<0 || (x% 10 ==0 && x != 0)) {
4            return false;
5    }
6    int rev = 0;
7    while (x> rev) {
8        rev = rev * 10 + x % 10;
9        x = x / 10;
10    }
11    return (x== rev || x == rev / 10);
12}
13}