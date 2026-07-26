// Last updated: 26/07/2026, 23:02:51
1class Solution {
2    public int strStr(String haystack, String needle) {
3        int n = haystack.length();
4        int m = needle.length();
5        for ( int i = 0; i <= n - m; i++) {
6        int j = 0;
7        while ( j < m && haystack.charAt(i + j) == needle.charAt(j)) {
8            j++;
9        }   
10        if ( j == m) {
11        return i; 
12      }
13   }
14
15    return -1;
16  }
17}