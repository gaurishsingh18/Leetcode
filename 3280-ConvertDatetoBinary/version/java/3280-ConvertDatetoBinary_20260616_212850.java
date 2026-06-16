// Last updated: 16/06/2026, 21:28:50
1class Solution {
2    public String convertDateToBinary(String date) {
3        // Split the date into year, month, day
4        String[] parts = date.split("-");
5        
6        // Convert each part to integer, then to binary
7        String year = Integer.toBinaryString(Integer.parseInt(parts[0]));
8        String month = Integer.toBinaryString(Integer.parseInt(parts[1]));
9        String day = Integer.toBinaryString(Integer.parseInt(parts[2]));
10        
11        // Return in required format
12        return year + "-" + month + "-" + day;
13    }
14}