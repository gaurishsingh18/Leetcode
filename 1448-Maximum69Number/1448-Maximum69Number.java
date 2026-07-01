// Last updated: 01/07/2026, 21:26:00
class Solution {
    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;   // only one change allowed
            }
        }
        return Integer.parseInt(new String(arr));
    }
}