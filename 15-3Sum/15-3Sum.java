// Last updated: 04/07/2026, 21:11:13
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        List<List<Integer>> ans = new ArrayList<>();
4        Arrays.sort(nums);
5        for (int i = 0; i < nums.length - 2; i++) {
6            if (i > 0 && nums[i] == nums[i - 1]) {
7                continue;
8            }
9            int left = i + 1;
10            int right = nums.length - 1;
11            while ( left < right) {
12                int sum = nums[i] + nums[left] + nums[right];
13                  if (sum == 0) {
14                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
15                    while (left < right && nums[left] == nums[left + 1]) {
16                        left++;
17                    }
18                    while (left < right && nums[right] == nums[right - 1]) {
19                        right--;
20                    }
21                    left++;
22                    right--;
23                  }else if (sum < 0) {
24                    left++;
25                  }else {
26                    right--;
27                  }
28             }
29        }
30        return ans;
31    }
32}