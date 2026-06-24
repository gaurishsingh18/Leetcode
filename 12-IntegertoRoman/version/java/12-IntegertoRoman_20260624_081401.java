// Last updated: 24/06/2026, 08:14:01
1class Solution {
2    
3    public String intToRoman(int num) {
4        
5        int[] values = {
6            1000, 900, 500, 400,
7            100, 90, 50, 40,
8            10, 9, 5, 4, 1
9        };
10        
11        String[] roman = {
12            "M", "CM", "D", "CD",
13            "C", "XC", "L", "XL",
14            "X", "IX", "V", "IV", "I"
15        };
16        
17        StringBuilder ans = new StringBuilder();
18        
19        for (int i = 0; i < values.length; i++) {
20            
21            while (num >= values[i]) {
22                ans.append(roman[i]);
23                num -= values[i];
24            }
25        }
26        
27        return ans.toString();
28    }
29}