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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-101);
        ListNode previous = dummy;
        ListNode current1 = list1;
        ListNode current2 = list2;

        while (current1 != null && current2 != null) {

            if (current1.val <= current2.val) {
                ListNode newCurrent1 = current1.next;
                previous.next = current1;
                previous = current1;
                current1 = newCurrent1;
            } else if (current1.val > current2.val) {
                ListNode newCurrent2 = current2.next;
                previous.next = current2;
                previous = current2;
                current2 = newCurrent2;
            } 
        }

        if (current1 == null) {
            previous.next = current2;
        } else if (current2 == null) {
            previous.next = current1;
        }

        return dummy.next;

    }
}