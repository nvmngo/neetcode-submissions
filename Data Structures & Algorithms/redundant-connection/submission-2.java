class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //The intuition for this question: 
        /* 
        The loop will be created when:
            An edge consisting of 'two nodes of the graph' is established
        
        ** Once an edge is created (that does not make a loop), will make the number of graphs
        decrement **

        The algorithm:
        - Create a HashMap, storing the entries of 'key' & 'value' pair
            - WHERE, the 'key' will be the index of the node
            - AND, the 'value' will be the GRAPH, that the node is consisted in
        - Iterate through each edges:
            - IF, the edge connect TWO DIFFERENT GRAPH 
                - Update the HashMap with the new graphs
            - ELSE, mark the edge as RESULT
        - Return RESULT
        */

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 1, n = edges.length; i <= n; i++) {
            List<Integer> graph = new ArrayList<>();
            graph.add(i);
            hashMap.put(i, graph);
        }

        int[] res = new int[2];

        for (int[] edge : edges) {
            List<Integer> first = hashMap.get(edge[0]);
            List<Integer> second = hashMap.get(edge[1]);

            if (first == second) {
                res = edge;
            }

            first.addAll(second);

            for (int i : first) {
                hashMap.put(i, first);
            }
        }

        return res;
    }
}
