// Last updated: 22/06/2026, 19:55:42
1class Solution {
2    public int maxNumberOfBalloons(String text) {
3        int[] count = new int[26];
4        
5        for(char ch : text.toCharArray()) {
6            count[ch - 'a']++;
7        }
8
9        int b = count['b' - 'a'];
10        int a = count['a' - 'a'];
11        int l = count['l' - 'a'] / 2;
12        int o = count['o' - 'a'] / 2;
13        int n = count['n' - 'a'];
14
15        int answer = Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
16        
17        return answer;
18    }
19}