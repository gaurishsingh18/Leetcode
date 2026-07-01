// Last updated: 01/07/2026, 21:25:44
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns) {
            if (word.contains(s)) {
                count++;
            }
        }
        return count;
    }
}