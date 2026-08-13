// Last updated: 14/08/2026, 01:12:46
1class Solution {
2    
3    class Node {
4        char leftChar, rightChar;
5        int prefix, suffix, max, len;
6        
7        Node(char c) {
8            leftChar = rightChar = c;
9            prefix = suffix = max = len = 1;
10        }
11        
12        Node() {}
13    }
14    
15    Node[] seg;
16    char[] arr;
17    
18    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
19        int n = s.length();
20        arr = s.toCharArray();
21        seg = new Node[4 * n];
22        
23        build(1, 0, n - 1);
24        
25        int k = queryIndices.length;
26        int[] res = new int[k];
27        
28        for (int i = 0; i < k; i++) {
29            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
30            res[i] = seg[1].max;
31        }
32        
33        return res;
34    }
35    
36    private void build(int idx, int l, int r) {
37        if (l == r) {
38            seg[idx] = new Node(arr[l]);
39            return;
40        }
41        
42        int mid = (l + r) / 2;
43        build(2 * idx, l, mid);
44        build(2 * idx + 1, mid + 1, r);
45        
46        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
47    }
48    
49    private void update(int idx, int l, int r, int pos, char c) {
50        if (l == r) {
51            arr[pos] = c;
52            seg[idx] = new Node(c);
53            return;
54        }
55        
56        int mid = (l + r) / 2;
57        
58        if (pos <= mid)
59            update(2 * idx, l, mid, pos, c);
60        else
61            update(2 * idx + 1, mid + 1, r, pos, c);
62        
63        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
64    }
65    
66    private Node merge(Node left, Node right) {
67        Node res = new Node();
68        
69        res.leftChar = left.leftChar;
70        res.rightChar = right.rightChar;
71        res.len = left.len + right.len;
72        
73        // prefix
74        res.prefix = left.prefix;
75        if (left.prefix == left.len && left.rightChar == right.leftChar) {
76            res.prefix = left.len + right.prefix;
77        }
78        
79        // suffix
80        res.suffix = right.suffix;
81        if (right.suffix == right.len && left.rightChar == right.leftChar) {
82            res.suffix = right.len + left.suffix;
83        }
84        
85        // max
86        res.max = Math.max(left.max, right.max);
87        if (left.rightChar == right.leftChar) {
88            res.max = Math.max(res.max, left.suffix + right.prefix);
89        }
90        
91        return res;
92    }
93}