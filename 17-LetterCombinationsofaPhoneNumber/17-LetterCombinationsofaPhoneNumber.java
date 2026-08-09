// Last updated: 09/08/2026, 20:35:33
1class Solution {
2    public List<String> letterCombinations(String digits) {
3        List<String> result = new ArrayList<>();
4        if (digits == null || digits.length() == 0) {
5            return result;
6        }
7        String[] map = {
8            "",     // 0
9            "",     // 1
10            "abc",  // 2
11            "def",  // 3
12            "ghi",  // 4
13            "jkl",  // 5
14            "mno",  // 6
15            "pqrs", // 7
16            "tuv",  // 8
17            "wxyz"  // 9
18        };
19        backtrack(digits, 0, new StringBuilder(), result, map);
20        return result;
21    }
22    private void backtrack(String digits, int index, StringBuilder current,
23                           List<String> result, String[] map) {
24        if (index == digits.length()) {
25            result.add(current.toString());
26            return;
27        }
28        String letters = map[digits.charAt(index) - '0'];
29        for (char ch : letters.toCharArray()) {
30            current.append(ch);
31            backtrack(digits, index + 1, current, result, map);
32            current.deleteCharAt(current.length() - 1); // backtrack
33        }
34    }
35}