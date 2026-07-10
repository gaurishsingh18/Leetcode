// Last updated: 10/07/2026, 21:47:55
1class Solution {
2    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
3        if (root == null) return false;
4        if (isSame(root, subRoot)) return true;
5        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
6    }
7    private boolean isSame(TreeNode a, TreeNode b) {
8        if (a == null && b == null) return true;
9        if (a == null || b == null) return false;
10        if (a.val != b.val) return false;
11        return isSame(a.left, b.left) && isSame(a.right, b.right);
12    }
13}