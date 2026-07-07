// Last updated: 07/07/2026, 11:40:17
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
17    public boolean isSymmetric(TreeNode root) {
18        return isMirror(root.left, root.right);
19    }
20    private boolean isMirror(TreeNode a, TreeNode b) {
21        if ( a== null && b == null) return true;
22        if (  a == null || b == null) return false;
23
24        return a.val == b.val &&
25        isMirror(a.left, b.right) &&
26        isMirror(a.right, b.left);
27    }
28}