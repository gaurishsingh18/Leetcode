// Last updated: 06/08/2026, 20:52:27
1class Solution {
2    public List<Integer> postorderTraversal(TreeNode root) {
3        List<Integer> ans = new ArrayList<>();
4        postorder(root, ans);
5        return ans;
6    }
7    private void postorder(TreeNode node, List<Integer> ans) {
8        if (node == null) {
9            return;
10        }
11        postorder(node.left, ans);
12        postorder(node.right, ans);
13        ans.add(node.val);
14    }
15}