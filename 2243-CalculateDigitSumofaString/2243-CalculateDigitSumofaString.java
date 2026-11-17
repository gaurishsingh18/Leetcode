// Last updated: 17/11/2026, 14:34:44
1class Solution {
2    public String digitSum(String s, int k) {
3        while (s.length() > k) {
4            StringBuilder nextString = new StringBuilder();
5            for (int i = 0; i < s.length(); i += k) {
6                int end = Math.min(i + k, s.length());
7                String group = s.substring(i, end);
8                int sum = 0;
9                for (int j = 0; j < group.length(); j++) {
10                    sum += group.charAt(j) - '0';
11                }
12                nextString.append(sum);
13            }
14            s = nextString.toString();
15        }
16        return s;
17    }
18}