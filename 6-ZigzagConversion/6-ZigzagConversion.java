// Last updated: 26/07/2026, 22:54:21
1class Solution {
2    public String convert(String s, int numRows) {
3        if (numRows == 1 || s.length() <= numRows) return s;
4        StringBuilder[] rows = new StringBuilder[numRows];
5        for (int i = 0; i < numRows; i++) {
6            rows[i] = new StringBuilder();
7        }
8        int idx = 0;
9        boolean down = true;
10        for (char c : s.toCharArray()) {
11            rows[idx].append(c);
12            if (idx == 0) {
13                down = true;
14            } else if (idx == numRows - 1) {
15                down = false;
16            }
17            idx += down ? 1 : -1;
18        }
19        StringBuilder ans = new StringBuilder();
20        for (StringBuilder row : rows) {
21            ans.append(row);
22        }
23        return ans.toString();
24    }
25}