// Last updated: 17/10/2026, 15:08:57
1import java.util.Arrays;
2
3class Solution {
4    public int minSwaps(int[] nums) {
5        int n = nums.length;
6        int[][] arr = new int[n][3];
7        
8        for (int i = 0; i < n; i++) {
9            arr[i][0] = getDigitSum(nums[i]);
10            arr[i][1] = nums[i];
11            arr[i][2] = i;
12        }
13        
14        Arrays.sort(arr, (a, b) -> {
15            if (a[0] != b[0]) {
16                return Integer.compare(a[0], b[0]);
17            }
18            return Integer.compare(a[1], b[1]);
19        });
20        
21        boolean[] visited = new boolean[n];
22        int swaps = 0;
23        
24        for (int i = 0; i < n; i++) {
25            if (visited[i] || arr[i][2] == i) {
26                continue;
27            }
28            
29            int cycleSize = 0;
30            int j = i;
31            
32            while (!visited[j]) {
33                visited[j] = true;
34                j = arr[j][2];
35                cycleSize++;
36            }
37            
38            if (cycleSize > 1) {
39                swaps += (cycleSize - 1);
40            }
41        }
42        
43        return swaps;
44    }
45    
46    private int getDigitSum(int num) {
47        int sum = 0;
48        while (num > 0) {
49            sum += num % 10;
50            num /= 10;
51        }
52        return sum;
53    }
54}