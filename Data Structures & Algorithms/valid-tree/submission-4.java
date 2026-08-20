class Solution {
    public boolean validTree(int n, int[][] edges) {
        //The intuition for this question:
        /* 
        ** The approach to this question is using BFS **

        The reason why:
            A Tree can only be invalid under these two circumstances:
            - Among the nodes, exists SEPERATE NODES that are connected to a graph
            - OR, within the tree, exists a LOOP
                - WHICH MEANS, a node have its child's child as its descendant
        
        BFS helps to check both of these condition
        
        The algorithm:
        - Create a HashMap, storing the entries of KEY & VALUE pair
            - WHERE the 'KEY' will be the index of the node
            - AND the 'VALUE' will be the list of adjacents to the node
        - Selecting a starting node and perform BFS onto the graph
            - Along with the traversal, at the current node that we are considering,
            has already registered into the visited node
                - RETURN FALSE
        - At the end of the traversal, if all nodes have been visited
            - RETRURN TRUE
            - Otherwise, RETURN FALSE
        */

        //Creating and Registering the entries of the HashMap
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            //registering
            hashMap.put(i, new ArrayList<Integer>());
        }

        for (int i = 0, m = edges.length; i < m; i++) {
            //updating
            if (edges[i][0] == edges[i][1]) return false;

            hashMap.get(edges[i][0]).add(edges[i][1]);
            hashMap.get(edges[i][1]).add(edges[i][0]); 
        } 

        //Searching
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        queue.offer(0);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            if (visited[node] == 1) { return false; }
            visited[node] = 1;

            List<Integer> children = hashMap.get(node);
            for (int child : children) {
                if (visited[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        for (int i : visited) {
            if (i == 0) {
                return false;
            }
        }

        return true; 

    }
}
