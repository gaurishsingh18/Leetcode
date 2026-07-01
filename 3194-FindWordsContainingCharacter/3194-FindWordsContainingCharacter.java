// Last updated: 01/07/2026, 21:25:17
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList();
        for(int i = 0; i < words.length; i++){
            if (words[i].indexOf(x) != -1){
                ans.add(i);
            }
        }return ans;
    }
}