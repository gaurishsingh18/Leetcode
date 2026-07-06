// Last updated: 06/07/2026, 21:35:23
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode sortedArrayToBST(int[] nums) {
18        return build(nums, 0, nums.length - 1);
19    }
20    private TreeNode build(int[] nums, int left, int right) {
21        if (left > right)
22        return null;
23
24        int mid = left + (right - left) / 2;
25        TreeNode root = new TreeNode(nums[mid]);
26        
27        root.left = build(nums, left, mid - 1);
28        root.right = build(nums, mid + 1, right);
29
30        return root;
31    }
32}