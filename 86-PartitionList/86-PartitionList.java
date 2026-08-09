// Last updated: 09/08/2026, 20:41:23
1class Solution {
2    public ListNode partition(ListNode head, int x) {
3        ListNode smallHead = new ListNode(0);
4        ListNode bigHead = new ListNode(0);
5        ListNode small = smallHead;
6        ListNode big = bigHead;
7        while (head != null) {
8            if (head.val < x) {
9                small.next = head;
10                small = small.next;
11            } else {
12                big.next = head;
13                big = big.next;
14            }
15            head = head.next;
16        }
17        big.next = null;
18        small.next = bigHead.next;
19        return smallHead.next;
20    }
21}