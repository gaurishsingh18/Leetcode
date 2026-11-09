// Last updated: 09/11/2026, 20:21:54
1class Solution {
2    public ListNode swapPairs(ListNode head) {
3        ListNode dummy = new ListNode(0);
4        dummy.next = head;
5        ListNode current = dummy;
6        
7        while (current.next != null && current.next.next != null) {
8            ListNode first = current.next;
9            ListNode second = current.next.next;
10            
11            first.next = second.next;
12            second.next = first;
13            current.next = second;
14            
15            current = first;
16        }
17        
18        return dummy.next;
19    }
20}