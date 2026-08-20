/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode current1 = l1;
        ListNode current2 = l2;
        int remain = 0;

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (!(current1 == null && current2 == null)) {
            int sum = (current1 != null ? current1.val : 0)
                    + (current2 != null ? current2.val : 0) + remain;
            
            current.next = new ListNode(sum%10);
            current = current.next;
            current1 = (current1 != null ? current1.next : null);
            current2 = (current2 != null ? current2.next : null);
            remain = sum/10;
        }

        if (remain != 0) { current.next = new ListNode(remain); }

        return dummy.next;
    }
}
