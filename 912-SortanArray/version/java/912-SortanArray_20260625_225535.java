// Last updated: 25/06/2026, 22:55:35
1class Solution {
2    public int[] sortArray(int[] nums) {
3        mergeSort(nums, 0, nums.length - 1);
4        return nums;
5    }
6    private void mergeSort(int[] arr, int left, int right) {
7        if (left >= right) return;
8        int mid = left + (right - left) / 2;
9        mergeSort(arr, left, mid);
10        mergeSort(arr, mid + 1, right);
11        merge(arr, left, mid, right);
12    }
13    private void merge(int[] arr, int left, int mid, int right) {
14        int[] temp = new int[right - left + 1];
15        int i = left;
16        int j = mid + 1;
17        int k = 0;
18        while (i <= mid && j <= right) {
19            if (arr[i] <= arr[j]) {
20                temp[k++] = arr[i++];
21            } else {
22                temp[k++] = arr[j++];
23            }
24        }
25        while (i <= mid) {
26            temp[k++] = arr[i++];
27        }
28        while (j <= right) {
29            temp[k++] = arr[j++];
30        }
31        for (int x = 0; x < temp.length; x++) {
32            arr[left + x] = temp[x];
33        }
34    }
35}