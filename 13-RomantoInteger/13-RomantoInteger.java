// Last updated: 26/06/2026, 13:52:57
1class Solution {
2    public int romanToInt(String s) {
3       int total = 0;
4       for ( int i = 0; i< s.length(); i++){
5        int curr = value(s.charAt(i));
6        if (i<s.length() - 1 && curr < value(s.charAt(i +1))) {
7            total-= curr;
8        } else{
9            total += curr;
10        }
11       } 
12       return total;
13    }
14    public int value(char ch) {
15        switch (ch){
16            case 'I': return 1;
17            case 'V': return 5;
18            case 'X': return 10;
19            case 'L': return 50;
20            case 'C': return 100;
21            case 'D': return 500;
22            case 'M': return 1000;
23        }
24        return 0;
25    }
26}