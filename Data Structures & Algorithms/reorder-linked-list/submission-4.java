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
    public void reorderList(ListNode head) {

        if (head.next == null || head.next.next == null) {
            return;
        } 

        Stack<ListNode> stack = new Stack<>();
        
        ListNode current = head; 
        while (true) {
            stack.push(current);
            if (current.next == null) {
                current = head;
                break;
            }
            current = current.next;
        }

        ListNode popped = stack.pop();
        while (true) {
            if (current.next.val == popped.val) {
                current.next.next = null;
                break;
            } else if (current.val == popped.val) {
                current.next = null; 
                break;
            } 
            else {
                popped.next = current.next;
                current.next = popped;
                current = current.next.next;
                popped = stack.pop();
            }
        }
    }
}
