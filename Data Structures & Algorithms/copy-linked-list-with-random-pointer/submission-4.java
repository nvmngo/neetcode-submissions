/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null) { return head; }

        Node copy = new Node(head.val);

        HashMap<Node, Node> hashMap = new HashMap<>();
        hashMap.put(head, copy);

        Node prev = copy;
        Node curr = head.next;
        Node rand = head.random;

        //iterating through the list
        while (curr != null) {
            if (!hashMap.containsKey(curr)) {
                hashMap.put(curr, new Node(curr.val));
            }

            if (rand == null) {
            } else if (!hashMap.containsKey(rand)) {
                hashMap.put(rand, new Node(rand.val));
            }

            prev.next = hashMap.get(curr);
            prev.random = (rand != null) ? hashMap.get(rand) : null;
            prev = prev.next;
            rand = curr.random;
            curr = curr.next;
        }

        prev.next = null;
        prev.random = (rand != null) ? hashMap.get(rand) : null;

        //returning the head
        return copy;
    }
}
