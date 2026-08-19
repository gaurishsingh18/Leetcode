// Last updated: 19/08/2026, 20:45:48
1class Solution {
2    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
3        Map<Integer, Integer> map = new HashMap<>();
4        for (int[] seat : reservedSeats) {
5            int row = seat[0];
6            int col = seat[1];
7            if (col >= 2 && col <= 9) {
8                int mask = map.getOrDefault(row, 0);
9                mask |= (1 << col);
10                map.put(row, mask);
11            }
12        }
13        int result = 0;
14        result += (n - map.size()) * 2;
15        for (int mask : map.values()) {
16            boolean left = (mask & ((1<<2)|(1<<3)|(1<<4)|(1<<5))) == 0;
17            boolean right = (mask & ((1<<6)|(1<<7)|(1<<8)|(1<<9))) == 0;
18            boolean middle = (mask & ((1<<4)|(1<<5)|(1<<6)|(1<<7))) == 0;
19            if (left && right) {
20                result += 2;
21            } else if (left || right || middle) {
22                result += 1;
23            }
24        }
25        return result;
26    }
27}