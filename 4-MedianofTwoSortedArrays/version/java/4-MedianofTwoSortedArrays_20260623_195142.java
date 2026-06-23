// Last updated: 23/06/2026, 19:51:42
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        
4        if (nums1.length > nums2.length) {
5            return findMedianSortedArrays(nums2, nums1);
6        }
7
8        int m = nums1.length;
9        int n = nums2.length;
10
11        int low = 0;
12        int high = m;
13
14        while (low <= high) {
15
16            int cut1 = (low + high) / 2;
17            int cut2 = (m + n + 1) / 2 - cut1;
18
19            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
20            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
21
22            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
23            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
24
25            if (left1 <= right2 && left2 <= right1) {
26
27                if ((m + n) % 2 == 0) {
28                    int maxLeft = Math.max(left1, left2);
29                    int minRight = Math.min(right1, right2);
30                    return (maxLeft + minRight) / 2.0;
31                } else {
32                    return Math.max(left1, left2);
33                }
34
35            } else if (left1 > right2) {
36                high = cut1 - 1;
37            } else {
38                low = cut1 + 1;
39            }
40        }
41
42        return 0.0;
43    }
44}