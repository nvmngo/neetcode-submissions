class Solution {
    public int countComponents(int n, int[][] edges) {
        //The intuition for this question:
        /* 
        We will use a quite similar approach to this question as the previous ones

        - Create a HashMap, storing the entries of 'key' & 'value' pair
            - WHERE, the 'key' will be the index of the node
            - AND, the 'value' will be the List of its adjacencies
        
        - Make use of BFS:
            - Iterate through each of every node/vertex
            - Use BFS to explore all possible branch of the graph
                - Simultaneously, mark those unvisited node as 'visited'
            - End when the search is finish

            - Once, finish with the first iteration
                - The second and after iteration would be just then check
                if whether the current node is 'visited'
                    - if YES, skip the iteration
                    - if NO, continue with the BFS, searching for all nodes
                    connected to that graph.
                        - Increment the count
        */

        //Create and Registering entries of the HashMap
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(i, new ArrayList<Integer>());
        }

        for (int i = 0, l = edges.length; i < l; i++) {
            hashMap.get(edges[i][0]).add(edges[i][1]);
            hashMap.get(edges[i][1]).add(edges[i][0]);
        }

        //BFS Algorithm
        int count = 0;
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                //increment the count
                count++;
                queue.offer(i);
                visited[i] = 1;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    List<Integer> adjacents = hashMap.get(node);

                    for (int adjacent : adjacents) {
                        if (visited[adjacent] == 0) {
                            queue.offer(adjacent);
                            visited[adjacent] = 1;
                        }
                    }
                }
            }
        }

        return count;
    }
}
