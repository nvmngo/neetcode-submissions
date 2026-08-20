class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : stones) {
            heap.offer(n);
        }

        while (heap.size() > 1) {
            int one = heap.poll();
            int two = heap.poll();

            one = Math.abs(one - two);
            if (one != 0) { heap.offer(one); }
        }        

        if (heap.size() == 0) return 0;
        return heap.peek();
    }
}
