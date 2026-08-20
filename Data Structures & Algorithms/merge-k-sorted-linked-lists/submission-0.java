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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) { return null; }

        //the intuition is to seperate the lists into pairs
        //the pair will be then merge, in the ascending order
        //we will then repeat the proccess 

        if (lists.length == 1) { return lists[0]; }     //base case

        int length = lists.length;

        ListNode[] lists1 = new ListNode[length/2];
        ListNode[] lists2 = new ListNode[length - lists1.length];

        int i = 0; //pointer for the left array
        int j = 0; //pointer for the right array

        for (; i < length; i++) {
            if (i < lists1.length) {
                lists1[i] = lists[i];
            } else {
                lists2[j] = lists[i];
                j++;
            }
        }

        ListNode one = mergeKLists(lists1);
        ListNode two = mergeKLists(lists2);

        return merge2Lists(one, two);
    }

    public ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode res = new ListNode();
        ListNode curr = res;

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }

            curr = curr.next;
        }

        if (curr1 == null) {
            while (curr2 != null) {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
            }
        } else if (curr2 == null) {
            while (curr1 != null) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            }
        }

        return res.next;
    }
}
