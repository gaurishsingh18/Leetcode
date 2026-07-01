// Last updated: 01/07/2026, 21:17:33
1class Solution {
2    public List<Integer> findWordsContaining(String[] words, char x) {
3        List<Integer> ans = new ArrayList();
4        for(int i = 0; i < words.length; i++){
5            if (words[i].indexOf(x) != -1){
6                ans.add(i);
7            }
8        }return ans;
9    }
10}