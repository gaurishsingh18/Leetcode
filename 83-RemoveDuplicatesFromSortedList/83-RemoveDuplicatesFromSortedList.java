// Last updated: 01/07/2026, 21:26:18
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;   // remove duplicate
            } else {
                curr = curr.next;             // move forward
            }
        }
        return head;
    }
}