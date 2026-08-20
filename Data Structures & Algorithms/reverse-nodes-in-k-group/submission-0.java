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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null) return null;          //handle edge case of 0
        if (head.next == null) return head;     //handle edge case of single-length list

        //counting the elements
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            if (count == k) {
                break;
            }

            count++;
            curr = curr.next;
        }
        
        //base case
        if (count < k) { return head; }

        ListNode prev = null;
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return this.merge(prev, this.reverseKGroup(curr, k));
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        //merge these two lists
        ListNode curr1 = head1;
        while (curr1.next != null) {
            curr1 = curr1.next;
        }

        curr1.next = head2;
        return head1;
    }
}
