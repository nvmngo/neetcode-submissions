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
    public boolean hasCycle(ListNode head) {
        
        if (head == null) {
            return false;
        }

        ListNode current = head;

        while (true) {
            if (current.next == null) {
                return false;
            } else if (current.next.val == 0) {
                return true;
            } else {
                current.val = 0;
                current = current.next;
            }
        }
    }
}
