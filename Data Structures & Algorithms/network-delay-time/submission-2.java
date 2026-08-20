class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // The intuition for this question:
        /* 
        Using the DIJKSTRA algorithm -> finding the SHORTEST path to reach every node
        */

        // Storing all the adjacencies in a HashMap
        HashMap<Integer, List<int[]>> hashMap = new HashMap<>();

        for (int[] edge : times) {
            if (!hashMap.containsKey(edge[0])) {
                hashMap.put(edge[0], new ArrayList<int[]>());
            }

            hashMap.get(edge[0]).add(edge);
        }

        HashSet<Integer> visited = new HashSet<>();
        // storing the adjacent in the form {time, node}
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[]a, int[]b) -> Integer.compare(a[0], b[0]));

        int curr = k;
        heap.add(new int[]{0, k});

        while (!heap.isEmpty()) {
            
            while (heap.size() != 0 && visited.contains(heap.peek()[1])) {
                heap.poll();
            }

            if (heap.size() == 0) {
                break;
            }

            int[] edge = heap.poll();
            visited.add(edge[1]);

            if (visited.size() == n) {
                return edge[0];
            }

            if (!hashMap.containsKey(edge[1])) { 
                continue;
            }

            for (int[] choice : hashMap.get(edge[1])) {
                if (!visited.contains(choice[1])) {
                    heap.offer(new int[]{edge[0] + choice[2], choice[1]});
                }
            }
        }

        return -1;
    }
}
