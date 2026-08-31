// Last updated: 31/08/2026, 21:18:21
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public int[] nodesBetweenCriticalPoints(ListNode head) {
13        if (head == null || head.next == null || head.next.next == null) {
14            return new int[]{-1, -1};
15        }
16
17        int min_dist = Integer.MAX_VALUE;
18        int first_crit_idx = -1;
19        int last_crit_idx = -1;
20
21        ListNode prev = head;
22        ListNode curr = head.next;
23        int idx = 1;
24
25        while (curr.next != null) {
26            ListNode next_node = curr.next;
27            
28            // Check for local maxima or local minima
29            if ((curr.val > prev.val && curr.val > next_node.val) ||
30                (curr.val < prev.val && curr.val < next_node.val)) {
31
32                if (first_crit_idx == -1) {
33                    first_crit_idx = idx; // First critical point found
34                } else {
35                    // Update min distance
36                    min_dist = Math.min(min_dist, idx - last_crit_idx);
37                }
38                last_crit_idx = idx;
39            }
40            prev = curr;
41            curr = next_node;
42            idx++;
43        }
44
45        if (min_dist == Integer.MAX_VALUE) {
46            return new int[]{-1, -1};
47        }
48        
49        return new int[]{min_dist, last_crit_idx - first_crit_idx};
50    }
51}