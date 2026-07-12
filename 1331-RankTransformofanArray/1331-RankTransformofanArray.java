// Last updated: 12/07/2026, 15:11:37
1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int n = arr.length;
4        int[] temp = arr.clone();
5        Arrays.sort(temp);
6        HashMap<Integer, Integer> map = new HashMap<>();
7        int rank = 1;
8        for (int num : temp) {
9            if (!map.containsKey(num)) {
10                map.put(num, rank);
11                rank++;
12            }
13        }
14        for (int i = 0; i < n; i++) {
15            arr[i] = map.get(arr[i]);
16        }
17        return arr;
18    }
19}