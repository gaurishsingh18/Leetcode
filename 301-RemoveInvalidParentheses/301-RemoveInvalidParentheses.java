// Last updated: 07/10/2026, 12:25:11
1class Solution {
2    public List<String> removeInvalidParentheses(String s) {
3        List<String> res = new ArrayList<>();
4        if (s == null) return res;
5
6        Set<String> visited = new HashSet<>();
7        Queue<String> q = new LinkedList<>();
8        q.offer(s);
9        visited.add(s);
10        boolean found = false;
11
12        while (!q.isEmpty()) {
13            int size = q.size();
14            Set<String> levelRes = new HashSet<>();
15            for (int i = 0; i < size; i++) {
16                String curr = q.poll();
17                if (isValid(curr)) {
18                    levelRes.add(curr);
19                    found = true;
20                }
21                if (!found) {
22                    for (int j = 0; j < curr.length(); j++) {
23                        if (curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;
24                        String next = curr.substring(0, j) + curr.substring(j + 1);
25                        if (!visited.contains(next)) {
26                            visited.add(next);
27                            q.offer(next);
28                        }
29                    }
30                }
31            }
32            if (found) {
33                res.addAll(levelRes);
34                break;
35            }
36        }
37        return res;
38    }
39    private boolean isValid(String s) {
40        int count = 0;
41        for (char c : s.toCharArray()) {
42            if (c == '(') count++;
43            else if (c == ')') {
44                count--;
45                if (count < 0) return false;
46            }
47        }
48        return count == 0;
49    }
50}