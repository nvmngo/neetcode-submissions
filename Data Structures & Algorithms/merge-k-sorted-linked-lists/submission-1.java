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

        while (lists.length > 1) {
            ListNode[] dummy = new ListNode[lists.length/2 + lists.length%2];
            int count = 0;
            for (int i = 0, n = lists.length; i < n; i+=2) {
                ListNode one = lists[i];
                ListNode two = (i + 1 < n) ? lists[i + 1] : null;

                dummy[count] = this.merge2Lists(one, two);
                count++;
            }
            lists = dummy;
        }

        return lists[0];
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
