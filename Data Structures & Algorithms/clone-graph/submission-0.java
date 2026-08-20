/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //The intuition for this question:
        /*
        We will implement a program:
        - Starting from the first node, creating the clone of the first node
        - If there're neighbours, create clone of them
            - Then register them into the Clone Map
            - Then add them into the clone's neighbour
            - Also add the auth nodes into a Queue
        - Start polling from the queue
            - Check the neighbours
            - If the neighbours have been registered into the clone
                - add them into our neighbour
            - Else create new clones and register them into the Clone Map
                - add the auth nodes into the Queue

        Stop when the queue is empty 

        - We will need to store the CLONE NODES
        -> HashMap
        */

        //edge case
        if (node == null) { return null; }

        //Essential Data Structure
        HashMap<Integer, Node> hashMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        //Creating the clone of the first node instance
        hashMap.put(node.val, new Node(node.val));

        //adding the neighbours into the queue and hashMap 
        for (Node n : node.neighbors) {
            hashMap.put(n.val, new Node(n.val));
            queue.offer(n);

            hashMap.get(node.val).neighbors.add(hashMap.get(n.val));
        }

        //looping through the queue
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Node clone = hashMap.get(n.val);

            for (Node _n : n.neighbors) {
                //if the neighbour have already been registered
                if (!hashMap.containsKey(_n.val)) {
                    //create new instance of clone
                    hashMap.put(_n.val, new Node(_n.val));
                    queue.offer(_n);
                }

                clone.neighbors.add(hashMap.get(_n.val));
            }
        }

        return hashMap.get(node.val);
    }
}