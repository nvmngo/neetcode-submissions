class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // The intuition for this question:
        /* 
            Approach with a DIJKSTRA approach:

            At a certain airport, choose the next destination to be the airport with the cheapest price STARTING FROM SRC:
            - Continuously, update the cost to reach to destinations 
        */

        // Storing the flights from a airport in a HASHMAP
        HashMap<Integer, List<int[]>> hashMap = new HashMap<>();

        for (int[] flight : flights) {
            // registering every airport to the hashMap
            hashMap.putIfAbsent(flight[0], new ArrayList<int[]>());
            hashMap.putIfAbsent(flight[1], new ArrayList<int[]>());

            hashMap.get(flight[0]).add(flight);
        }

        // [destination, k, price]
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
            (int[] a, int[] b) -> Integer.compare(a[2], b[2])
        );

        // cache
        int[][] cache = new int[n][k + 2];

        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }


        // initialising the heap
        heap.offer(new int[]{src, 0, 0});
        cache[src][0] = 0;

        while (!heap.isEmpty()) {

            int[] curr = heap.poll();
            
            int airport = curr[0];
            int flightsUsed = curr[1];
            int price = curr[2];

            if (curr[0] == dst) {
                return curr[2];
            }

            if (curr[1] > k) {
                continue;
            }

            for (int[] flight : hashMap.get(airport)) {

                int nextAirport = flight[1];
                int newFlights = flightsUsed + 1;
                int newPrice = price + flight[2];

                if (newPrice < cache[nextAirport][newFlights]) {

                    cache[nextAirport][newFlights] = newPrice;

                    heap.offer(new int[]{
                        nextAirport,
                        newFlights,
                        newPrice
                    });
                }
            }
        }

        return -1;
    }
}
