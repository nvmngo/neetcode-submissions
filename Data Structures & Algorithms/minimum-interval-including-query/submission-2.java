class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];
        
        //sorting the intervals 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //hash-map storing the entries of 'query value' to 'query index'
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        //registering the entries
        for (int i = 0, n = queries.length; i < n; i++) {
            if (!hashMap.containsKey(queries[i])) {
                hashMap.put(queries[i], new ArrayList<Integer>());
            }
            List<Integer> ls = hashMap.get(queries[i]);
            ls.add(i);
            hashMap.put(queries[i], ls);
        }

        //sort the queries 
        Arrays.sort(queries);

        //implementing a min-heap -> polling out the interval with smallest length
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[]a, int[]b) -> Integer.compare(a[1] - a[0], b[1] - b[0])); 
        
        //pointer pointing the current interval position that we're considering
        int i = 0;

        for (int query : queries) {
            //adding interval into the query
            while (i < intervals.length && intervals[i][0] <= query) {
                heap.offer(intervals[i]);
                i++;
            }

            while (!heap.isEmpty() && heap.peek()[1] < query) {
                heap.poll();
            }

            List<Integer> ls = hashMap.get(query);

            if (heap.isEmpty()) {
                for (int index : ls) {
                    res[index] = -1;
                }
            }

            else {
                int[] interval = heap.peek();
                for (int index : ls) {
                    res[index] = interval[1] - interval[0] + 1;
                }
            }
        }

        return res;
    }
}
