class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //The intuition for this question
        /* 
        - Modify the constructor of the PriorityQueue, so that if would have
        a sense of what is the 'priority' of an array
            - Since an array would not give any initial meaning about priority
            - Though, in this case, we're regarding it as a point in a cartesian plane

        - Make sure our PriorityQueue is a Max-heap data structure

        - Iterate through the points
        - Poll out points when the size of the queue is larger than 'k'
        - Return the final result
        */

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            //lambda expression, putting the values and shows the result
            (a, b) -> Long.compare(
                (long) Math.pow(b[0], 2) + (long) Math.pow(b[1], 2),
                (long) Math.pow(a[0], 2) + (long) Math.pow(a[1], 2)
            )
        );

        for (int[] point : points) {
            heap.offer(point);

            while (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = heap.poll();
            res[i] = point;
        }

        return res;
    }
}
