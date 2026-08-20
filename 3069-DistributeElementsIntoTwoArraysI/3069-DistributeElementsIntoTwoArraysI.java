// Last updated: 20/08/2026, 22:18:00
1class Solution {
2    public int[] resultArray(int[] nums) {
3        int n = nums.length;
4        List<Integer> arr1 = new ArrayList<>();
5        List<Integer> arr2 = new ArrayList<>();
6        arr1.add(nums[0]);
7        arr2.add(nums[1]);
8        for (int i = 2; i < n; i++) {
9            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
10                arr1.add(nums[i]);
11            } else {
12                arr2.add(nums[i]);
13            }
14        }
15        int[] result = new int[n];
16        int index = 0;
17        
18        for (int num : arr1) {
19            result[index++] = num;
20        }
21        for (int num : arr2) {
22            result[index++] = num;
23        }
24        return result;
25    }
26}