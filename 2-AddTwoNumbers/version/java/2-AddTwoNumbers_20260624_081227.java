// Last updated: 24/06/2026, 08:12:27
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { 
9 *         this.val = val; 
10 *         this.next = next; 
11 *     }
12 * }
13 */
14
15class Solution {
16    
17    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
18        
19        ListNode dummy = new ListNode(0);
20        ListNode curr = dummy;
21        
22        int carry = 0;
23        
24        while (l1 != null || l2 != null || carry != 0) {
25            
26            int first = 0;
27            int second = 0;
28            
29            if (l1 != null) {
30                first = l1.val;
31                l1 = l1.next;
32            }
33            
34            if (l2 != null) {
35                second = l2.val;
36                l2 = l2.next;
37            }
38            
39            int sum = first + second + carry;
40            
41            carry = sum / 10;
42            
43            curr.next = new ListNode(sum % 10);
44            curr = curr.next;
45        }
46        
47        return dummy.next;
48    }
49}