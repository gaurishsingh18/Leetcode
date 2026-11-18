// Last updated: 18/11/2026, 19:50:43
1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public boolean hasCycle(ListNode head) {
14        if (head == null || head.next == null) {
15            return false;
16        }
17        
18        ListNode slow = head;
19        ListNode fast = head;
20        
21        while (fast != null && fast.next != null) {
22            slow = slow.next;          // Moves 1 step
23            fast = fast.next.next;     // Moves 2 steps
24            
25            if (slow == fast) {
26                return true; // Cycle detected
27            }
28        }
29        
30        return false; // Reached the end, no cycle
31    }
32}