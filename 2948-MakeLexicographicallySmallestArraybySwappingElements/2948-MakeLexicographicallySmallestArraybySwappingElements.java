// Last updated: 29/08/2026, 15:55:19
1class Solution {
2    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
3        int n = nums.length;
4        int[][] arr = new int[n][2];
5        for (int i = 0; i < n; i++) {
6            arr[i][0] = nums[i];
7            arr[i][1] = i;
8        }
9        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
10        int[] res = new int[n];
11        int i = 0;
12        while (i < n) {
13            int j = i;
14            while (j + 1 < n && arr[j + 1][0] - arr[j][0] <= limit) {
15                j++;
16            }
17            List<Integer> indices = new ArrayList<>();
18            List<Integer> values = new ArrayList<>();
19            for (int k = i; k <= j; k++) {
20                indices.add(arr[k][1]);
21                values.add(arr[k][0]);
22            }
23            Collections.sort(indices);
24            Collections.sort(values);
25            for (int k = 0; k < indices.size(); k++) {
26                res[indices.get(k)] = values.get(k);
27            }
28            i = j + 1;
29        }
30        return res;
31    }
32}