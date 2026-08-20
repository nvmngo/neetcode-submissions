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

        //The spirit is, we want to divide the list into two different list
        //then the final goal would be connecting the two list with each other

        //where the other list would be the final end, and we would want the 
        //element of the second list to đan qua the elements in the first list

        //In order to divide the list, we would need to understand structures
        //of the list

        //Since the second one is jumping in every gaps, so first one would have
        //equal or one-element larger

        //Thus we would need to use an slow and fast pointers, always dividing the
        //list in the way we want it to be

        ListNode slow = head;
        ListNode fast = head.next; //giving the fast pointer a further start would give you the left middle of the list (or the true middle)

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next; //beginning of the second list
        slow.next = null; //setting the end of the first list

        //Reversing the second list
        ListNode previous = null;
        ListNode current = secondHead;
        while (current != null) {
            ListNode newCurrent = current.next;
            current.next = previous;
            previous = current;
            current = newCurrent;
        }
        
        secondHead = previous;

        //Merging the two lists
        while (head != null && secondHead != null) {
            ListNode newHead = head.next;
            ListNode new2Head = secondHead.next;
            secondHead.next = head.next;
            head.next = secondHead;
            head = newHead;
            secondHead = new2Head;
        }
    }
}
