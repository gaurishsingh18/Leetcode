// Last updated: 09/08/2026, 20:43:15
1class Solution {
2    int postIndex;
3    Map<Integer, Integer> map = new HashMap<>();
4    public TreeNode buildTree(int[] inorder, int[] postorder) {
5        int n = inorder.length;
6        postIndex = n - 1;
7        for (int i = 0; i < n; i++) {
8            map.put(inorder[i], i);
9        }
10        return build(inorder, postorder, 0, n - 1);
11    }
12    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {
13        if (left > right) return null;
14        int rootVal = postorder[postIndex--];
15        TreeNode root = new TreeNode(rootVal);
16        int index = map.get(rootVal);
17        root.right = build(inorder, postorder, index + 1, right);
18        root.left = build(inorder, postorder, left, index - 1);
19        return root;
20    }
21}