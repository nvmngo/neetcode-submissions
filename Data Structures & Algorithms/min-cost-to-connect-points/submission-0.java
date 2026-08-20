class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Finding the minimum distance path to connect all nodes -> Dijkstra Algorithms
        /* 
            The algorithm will be some sort similar to that:
            
            - Selecting a initial point, calculate the mahattan distance from the point to the other
            - Track the 'visited nodes'
            - Use a PriorityQueue - minheap - to get the shortest path
            - Add the mahattan distances in the Heap, correspond to each of the destination point
                - Poll out the heap for the closest point
                - From the point, calculate the mahattan distance again, and add in the minheap
                - Continue to do such thing
        */

        // set - data structure to store the unvisited point
        HashSet<int[]> unvisited = new HashSet<int[]>();
        // registering the point to the set
        for (int[] point : points) {
            unvisited.add(point);
        }

        // min-heap : data structure to poll out the next closest unvisited point
        PriorityQueue<Pair<Integer, int[]>> heap = new PriorityQueue<>(
            (Pair<Integer, int[]> a, Pair<Integer, int[]> b) -> Integer.compare(a.distance, b.distance)
        );
        // adding the first point to the min-heap
        heap.offer(new Pair<Integer, int[]>(0, points[0]));

        // return result
        int res = 0;
        // looping until we find all the points
        while (unvisited.size() != 0) {
            // polling out visited points - distances
            while (!heap.isEmpty() && !unvisited.contains(heap.peek().point)) {
                heap.poll();
            }

            if (heap.isEmpty()) {
                break;
            }

            // getting the closest unvisited point
            Pair<Integer, int[]> curr = heap.poll();
            res += curr.distance;
            // mark as visited
            unvisited.remove(curr.point);
            // adding new distance to points into the heap
            for (int[] point : unvisited) {
                int distance = Math.abs(curr.point[0] - point[0]) + Math.abs(curr.point[1] - point[1]);
                heap.offer(new Pair<Integer, int[]>(distance, point));
            }
        }

        return res;
    }

    class Pair<K, V> {
        K distance;
        V point;

        public Pair(K key, V value) {
            this.distance = key;
            this.point = value;
        }
    }
}
