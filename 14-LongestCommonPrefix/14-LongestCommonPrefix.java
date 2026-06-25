// Last updated: 25/06/2026, 23:09:20
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int index = 0;

        while (true) {
            if (index >= strs[0].length()) {
                break;
            }

            char current = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != current) {
                    return ans.toString();
                }
            }

            ans.append(current);
            index++;
        }

        return ans.toString();
    }
}