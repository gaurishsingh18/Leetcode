// Last updated: 06/07/2026, 21:38:39
1
2class Solution {
3    public TreeNode invertTree(TreeNode root) {
4        
5        if(root == null)
6        return null;
7
8        TreeNode temp = root.left;
9        root.left = root.right;
10        root.right = temp;
11
12        invertTree(root.left);
13        invertTree(root.right);
14        return root;
15    }
16}