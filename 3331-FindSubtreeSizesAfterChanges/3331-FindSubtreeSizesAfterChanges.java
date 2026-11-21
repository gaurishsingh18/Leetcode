// Last updated: 21/11/2026, 11:00:46
1class Solution {
2    public int[] findSubtreeSizes(int[] parent, String s) {
3        int n = parent.length;
4        List<Integer>[] origTree = new ArrayList[n];
5        for (int i = 0; i < n; i++) {
6            origTree[i] = new ArrayList<>();
7        }
8        for (int i = 1; i < n; i++) {
9            origTree[parent[i]].add(i);
10        }
11
12        int[] newParent = Arrays.copyOf(parent, n);
13        int[] lastSeen = new int[26];
14        Arrays.fill(lastSeen, -1);
15
16        dfsFindParents(0, s, origTree, lastSeen, newParent);
17
18        List<Integer>[] newTree = new ArrayList[n];
19        for (int i = 0; i < n; i++) {
20            newTree[i] = new ArrayList<>();
21        }
22        for (int i = 1; i < n; i++) {
23            newTree[newParent[i]].add(i);
24        }
25
26        int[] ans = new int[n];
27        dfsSubtreeSize(0, newTree, ans);
28        return ans;
29    }
30
31    private void dfsFindParents(int u, String s, List<Integer>[] tree, int[] lastSeen, int[] newParent) {
32        int c = s.charAt(u) - 'a';
33        int prev = lastSeen[c];
34        if (prev != -1) {
35            newParent[u] = prev;
36        }
37        lastSeen[c] = u;
38
39        for (int v : tree[u]) {
40            dfsFindParents(v, s, tree, lastSeen, newParent);
41        }
42
43        lastSeen[c] = prev;
44    }
45
46    private int dfsSubtreeSize(int u, List<Integer>[] tree, int[] ans) {
47        int size = 1;
48        for (int v : tree[u]) {
49            size += dfsSubtreeSize(v, tree, ans);
50        }
51        ans[u] = size;
52        return size;
53    }
54}