// Last updated: 07/07/2026, 12:02:04
1class Solution {
2    public int minDepth(TreeNode root) {
3        if( root == null) return 0;
4        if (root.left == null)
5        return minDepth(root.right) + 1;
6        if(root.right == null)
7        return minDepth(root.left) + 1;
8        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
9    }
10}