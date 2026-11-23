// Last updated: 23/11/2026, 14:06:13
1import java.util.ArrayList;
2import java.util.List;
3
4class ProductOfNumbers {
5    private List<Integer> prefix;
6
7    public ProductOfNumbers() {
8        prefix = new ArrayList<>();
9        prefix.add(1);
10    }
11
12    public void add(int num) {
13        if (num == 0) {
14            prefix.clear();
15            prefix.add(1);
16        } else {
17            int last = prefix.get(prefix.size() - 1);
18            prefix.add(last * num);
19        }
20    }
21
22    public int getProduct(int k) {
23        int n = prefix.size() - 1;
24        if (k > n) {
25            return 0;
26        }
27        return prefix.get(n) / prefix.get(n - k);
28    }
29}