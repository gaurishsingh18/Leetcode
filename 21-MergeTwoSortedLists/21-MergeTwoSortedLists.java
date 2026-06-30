// Last updated: 30/06/2026, 12:21:34
1class Solution {
2    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
3        ListNode dummy = new ListNode(-1);   // temporary node
4        ListNode curr = dummy;
5        while (list1 != null && list2 != null) {
6            if (list1.val <= list2.val) {
7                curr.next = list1;
8                list1 = list1.next;
9            } else {
10                curr.next = list2;
11                list2 = list2.next;
12            }
13            curr = curr.next;
14        }
15        if (list1 != null) {
16            curr.next = list1;
17        } else {
18            curr.next = list2;
19        }
20        return dummy.next; 
21    }
22}