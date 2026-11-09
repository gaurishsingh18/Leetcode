// Last updated: 09/11/2026, 20:22:48
1class Solution {
2    public ListNode removeNthFromEnd(ListNode head, int n) {
3        ListNode dummy = new ListNode(0);
4        dummy.next = head;
5        ListNode first = dummy;
6        ListNode second = dummy;
7        
8        for (int i = 0; i <= n; i++) {
9            first = first.next;
10        }
11        
12        while (first != null) {
13            first = first.next;
14            second = second.next;
15        }
16        
17        second.next = second.next.next;
18        
19        return dummy.next;
20    }
21}