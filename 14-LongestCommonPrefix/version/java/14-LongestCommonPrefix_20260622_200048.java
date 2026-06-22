// Last updated: 22/06/2026, 20:00:48
1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        StringBuilder ans = new StringBuilder();
4        int index = 0;
5
6        while (true) {
7            if (index >= strs[0].length()) {
8                break;
9            }
10
11            char current = strs[0].charAt(index);
12
13            for (int i = 1; i < strs.length; i++) {
14                if (index >= strs[i].length() || strs[i].charAt(index) != current) {
15                    return ans.toString();
16                }
17            }
18
19            ans.append(current);
20            index++;
21        }
22
23        return ans.toString();
24    }
25}