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
    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode next = null;
        if (current != null) {
            next = current.next;
        }

        while (next != null) {
            ListNode nextNew = next.next;
            next.next = current;
            current = next;
            next = nextNew;
        }

        if (current != null) {
            head.next = null;
        }
        return current;
    }
}
