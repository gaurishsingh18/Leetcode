// Last updated: 15/06/2026, 21:23:21
1class Solution {
2    public List<String> generateParenthesis(int n) {
3        
4        List<String> result = new ArrayList<>();
5        backtrack(result, "", 0, 0, n);
6        return result;
7    }
8    
9    private void backtrack(List<String> result, String curr, int open, int close, int n) {
10        
11        if (curr.length() == 2 * n) {
12            result.add(curr);
13            return;
14        }
15        
16        if (open < n) {
17            backtrack(result, curr + "(", open + 1, close, n);
18        }
19        
20        if (close < open) {
21            backtrack(result, curr + ")", open, close + 1, n);
22        }
23    }
24}