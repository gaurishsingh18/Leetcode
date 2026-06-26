// Last updated: 26/06/2026, 13:40:38
1class Solution {
2    public boolean rotateString(String s, String goal) {
3       if(s.length() != goal.length()){
4        return false;
5       } 
6       String str = s+ s;
7       if(str.contains(goal)) {
8        return true;
9       }
10       return false;
11    }
12}