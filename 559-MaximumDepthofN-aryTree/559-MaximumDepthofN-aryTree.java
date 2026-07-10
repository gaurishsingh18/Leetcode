// Last updated: 10/07/2026, 21:43:11
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
17};
18*/
19
20class Solution {
21    public int maxDepth(Node root) {
22        if ( root == null) return 0;
23        int depth = 0;
24        for(Node child : root.children){
25            depth = Math.max(depth, maxDepth(child));
26        }
27        return depth + 1;
28    }
29}