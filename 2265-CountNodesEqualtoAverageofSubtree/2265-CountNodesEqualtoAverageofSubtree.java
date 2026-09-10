// Last updated: 10/09/2026, 20:57:21
1class Solution {
2    int result = 0;
3
4    public int averageOfSubtree(TreeNode root) {
5        dfs(root);
6        return result;
7    }
8
9    private int[] dfs(TreeNode node) {
10        if (node == null) {
11            return new int[]{0, 0};
12        }
13
14        int[] left = dfs(node.left);
15        int[] right = dfs(node.right);
16
17        int sum = left[0] + right[0] + node.val;
18        int count = left[1] + right[1] + 1;
19
20        if (node.val == sum / count) {
21            result++;
22        }
23
24        return new int[]{sum, count};
25    }
26}