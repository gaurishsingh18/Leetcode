// Last updated: 06/08/2026, 20:42:37
1class Solution {
2    public boolean isPalindrome(String s) {
3        int left = 0, right = s.length() - 1;
4        while (left < right) {
5            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
6                left++;
7            }
8            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
9                right--;
10            }
11            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
12                return false;
13            }
14            left++;
15            right--;
16        }
17        return true;
18    }
19}