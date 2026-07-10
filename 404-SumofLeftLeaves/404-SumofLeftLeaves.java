// Last updated: 10/07/2026, 21:38:07
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
17    public int sumOfLeftLeaves(TreeNode root) {
18        if (root == null) return 0;
19        int sum = 0;
20        if (root.left != null) {
21            if (root.left.left == null && root.left.right == null) {
22                sum += root.left.val;
23            }else{
24                sum += sumOfLeftLeaves(root.left);
25            }
26        }
27        sum += sumOfLeftLeaves(root.right);
28        return sum;
29        
30    }
31}