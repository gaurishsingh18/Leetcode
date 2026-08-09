// Last updated: 09/08/2026, 20:44:41
1class Solution {
2    int preIndex = 0;
3    Map<Integer, Integer> map = new HashMap<>();
4    public TreeNode buildTree(int[] preorder, int[] inorder) {
5        int n = inorder.length;
6        for (int i = 0; i < n; i++) {
7            map.put(inorder[i], i);
8        }
9        return build(preorder, 0, n - 1);
10    }
11    private TreeNode build(int[] preorder, int left, int right) {
12        if (left > right) return null;
13        int rootVal = preorder[preIndex++];
14        TreeNode root = new TreeNode(rootVal);
15        int index = map.get(rootVal);
16        root.left = build(preorder, left, index - 1);
17        root.right = build(preorder, index + 1, right);
18        return root;
19    }
20}