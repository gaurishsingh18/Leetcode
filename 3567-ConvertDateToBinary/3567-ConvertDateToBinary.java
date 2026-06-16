// Last updated: 16/06/2026, 21:32:46
class Solution {
    public String convertDateToBinary(String date) {
        // Split the date into year, month, day
        String[] parts = date.split("-");
        
        // Convert each part to integer, then to binary
        String year = Integer.toBinaryString(Integer.parseInt(parts[0]));
        String month = Integer.toBinaryString(Integer.parseInt(parts[1]));
        String day = Integer.toBinaryString(Integer.parseInt(parts[2]));
        
        // Return in required format
        return year + "-" + month + "-" + day;
    }
}