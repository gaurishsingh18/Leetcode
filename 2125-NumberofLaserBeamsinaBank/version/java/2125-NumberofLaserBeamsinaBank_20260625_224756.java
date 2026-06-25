// Last updated: 25/06/2026, 22:47:56
1class Solution {
2    public int numberOfBeams(String[] bank) {
3        
4        int prev = 0;
5        int beams = 0;
6        
7        for (String row : bank) {
8            
9            int curr = 0;
10            
11            for (char ch : row.toCharArray()) {
12                if (ch == '1') {
13                    curr++;
14                }
15            }
16            
17            if (curr > 0) {
18                beams += prev * curr;
19                prev = curr;
20            }
21        }
22        
23        return beams;
24    }
25}