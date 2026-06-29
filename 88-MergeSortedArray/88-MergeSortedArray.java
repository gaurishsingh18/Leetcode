// Last updated: 30/06/2026, 00:03:53
1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        int i = m - 1;
4        int j = n - 1;
5        int k = m + n - 1;
6        while (i >= 0 && j >= 0) {
7            if (nums1[i] > nums2[j]) {
8                nums1[k] = nums1[i];
9                i--;
10            } else {
11                nums1[k] = nums2[j];
12                j--;
13            }
14            k--;
15        }
16        // copy remaining nums2 elements
17        while (j >= 0) {
18            nums1[k] = nums2[j];
19            j--;
20            k--;
21        }
22    }
23}