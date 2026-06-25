// Last updated: 25/06/2026, 22:49:19
1import java.util.*;
2class Solution {
3    public int[] createTargetArray(int[] nums, int[] index) {
4        ArrayList<Integer> list = new ArrayList<>();
5        for (int i = 0; i < nums.length; i++) {
6            list.add(index[i], nums[i]);
7        }
8        int[] target = new int[nums.length];
9        for (int i = 0; i < nums.length; i++) {
10            target[i] = list.get(i);
11        }
12        return target;
13    }
14}