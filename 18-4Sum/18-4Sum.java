// Last updated: 07/11/2026, 19:14:15
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> fourSum(int[] nums, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        if (nums == null || nums.length < 4) {
9            return result;
10        }
11        
12        Arrays.sort(nums);
13        int n = nums.length;
14        
15        for (int i = 0; i < n - 3; i++) {
16            if (i > 0 && nums[i] == nums[i - 1]) {
17                continue;
18            }
19            
20            for (int j = i + 1; j < n - 2; j++) {
21                if (j > i + 1 && nums[j] == nums[j - 1]) {
22                    continue;
23                }
24                
25                int left = j + 1;
26                int right = n - 1;
27                
28                while (left < right) {
29                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
30                    
31                    if (sum == target) {
32                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
33                        
34                        while (left < right && nums[left] == nums[left + 1]) {
35                            left++;
36                        }
37                        while (left < right && nums[right] == nums[right - 1]) {
38                            right--;
39                        }
40                        
41                        left++;
42                        right--;
43                    } else if (sum < target) {
44                        left++;
45                    } else {
46                        right--;
47                    }
48                }
49            }
50        }
51        
52        return result;
53    }
54}