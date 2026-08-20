class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Storing the tickets in a HashMap, retrieving the destinations in O(1) time
        HashMap<String, PriorityQueue<String>> hashMap = new HashMap<>();
        // registering 
        for (List<String> ticket : tickets) {
            if (!hashMap.containsKey(ticket.get(0))) {
                hashMap.put(ticket.get(0), new PriorityQueue<String>());    //min-heap treat String in lexical order
            }
            hashMap.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        // In this problem, what we're doing is FINDING the path, such that, we will visit all the nodes and edges 
        // WHERE the edges will be used exactly once
        /*
            Starting at position 'JFK' -> We will try to naively DFS, exploring the different flight path
            Once we encounter a dead-end THAT we still have more nodes&edges left unexplored
            ->  INSTEAD of trying a new flight path, we will ADD the current dead-end to the 'flight note' -> backtrack
            back to the previous node

            -> If the current node is stucked, add the node into the queue, and continue the backtrack
            -> If the current node have more unvisited edge -> Explore that branch

            -> Repeat the same process until we reached the starting position
         */

        // creating flight path list
        List<String> res = new LinkedList<>();

        helper("JFK", hashMap, res);
        return res;
    }

    // Implement a helper method -> visit the unvisited edge if there's any || backtrack if its a deadend
    public void helper(String curr, HashMap<String, PriorityQueue<String>> hashMap, List<String> res) {
        // if the current node is a deadend
        if (!hashMap.containsKey(curr) || hashMap.get(curr).isEmpty()) {
            res.add(0, curr);
            return;
        }

        PriorityQueue<String> heap = hashMap.get(curr);
        while (!heap.isEmpty()) {
            String next = heap.poll();
            helper(next, hashMap, res);
        }

        res.add(0, curr);
    }
}
