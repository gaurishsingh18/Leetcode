// Last updated: 13/07/2026, 16:04:56
1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        List<Integer> result = new ArrayList<>();
4        String digits = "123456789";
5        int lowLen = String.valueOf(low).length();
6        int highLen = String.valueOf(high).length();
7
8        for (int len = lowLen; len <= highLen; len++) {
9            for (int i = 0; i + len <= 9; i++) {
10                int num = Integer.parseInt(digits.substring(i, i + len));
11                if (num >= low && num <= high) {
12                  result.add(num);
13                }
14            }
15        }
16        return result;
17    }
18}