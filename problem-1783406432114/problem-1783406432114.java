// Last updated: 07/07/2026, 12:10:32
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> children;
6
7    public Node() {}
8
9    public Node(int _val) {
10        val = _val;
11    }
12
13    public Node(int _val, List<Node> _children) {
14        val = _val;
15        children = _children;
16    }
17}
18*/
19
20class Solution {
21    public List<Integer> postorder(Node root) {
22        List<Integer> ans= new ArrayList<>();            
23            dfs(root, ans);
24            return ans;
25        }
26        private void dfs(Node node, List<Integer> ans) {
27            if (node == null) return;
28            for(Node child : node.children) {
29                dfs(child, ans);
30            }
31            ans.add (node.val);
32        }
33    }
34