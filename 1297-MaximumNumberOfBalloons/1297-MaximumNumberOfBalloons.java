// Last updated: 25/06/2026, 23:09:04
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        
        for(char ch : text.toCharArray()) {
            count[ch - 'a']++;
        }

        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];

        int answer = Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
        
        return answer;
    }
}