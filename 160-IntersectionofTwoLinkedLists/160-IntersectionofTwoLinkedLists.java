// Last updated: 17/08/2026, 22:04:57
1public class Solution {
2    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
3        ListNode a = headA;
4        ListNode b = headB;
5        while (a != b) {
6            a = (a == null) ? headB : a.next;
7            b = (b == null) ? headA : b.next;
8        }
9        return a;
10    }
11}