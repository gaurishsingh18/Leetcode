// Last updated: 26/09/2026, 09:47:37
1class Solution {
2    public String evaluate(String s, List<List<String>> knowledge) {
3        Map<String, String> map = new HashMap<>();
4        for (List<String> pair : knowledge) {
5            map.put(pair.get(0), pair.get(1));
6        }
7        StringBuilder sb = new StringBuilder();
8        int n = s.length();
9        int i = 0;
10        while (i < n) {
11            char c = s.charAt(i);
12            if (c == '(') {
13                int j = i + 1;
14                while (j < n && s.charAt(j) != ')') {
15                    j++;
16                }
17                String key = s.substring(i + 1, j);
18                sb.append(map.getOrDefault(key, "?"));
19                i = j + 1;
20            } else {
21                sb.append(c);
22                i++;
23            }
24        }
25        return sb.toString();
26    }
27}