// Last updated: 26/06/2026, 13:54:48
1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder result = new StringBuilder();
4        int i = a.length() - 1;
5        int j = b.length() - 1;
6        int carry = 0;
7        while (i >= 0 || j >= 0 || carry != 0) {
8            int sum = carry;
9            if (i >= 0) {
10                sum += a.charAt(i) - '0';
11                i--;
12            }
13            if (j >= 0) {
14                sum += b.charAt(j) - '0';
15                j--;
16            }
17            result.append(sum % 2); 
18            carry = sum / 2;          
19        }
20        return result.reverse().toString();
21    }
22}