// Last updated: 25/06/2026, 23:08:49
class Solution {
    public int numberOfBeams(String[] bank) {
        
        int prev = 0;
        int beams = 0;
        
        for (String row : bank) {
            
            int curr = 0;
            
            for (char ch : row.toCharArray()) {
                if (ch == '1') {
                    curr++;
                }
            }
            
            if (curr > 0) {
                beams += prev * curr;
                prev = curr;
            }
        }
        
        return beams;
    }
}