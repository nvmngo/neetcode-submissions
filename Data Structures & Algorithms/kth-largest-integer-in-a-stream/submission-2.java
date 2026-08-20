class KthLargest {

    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();

        for (int n : nums) {
            this.heap.offer(n);
        }

        while (this.heap.size() > this.k) {
            this.heap.poll();
        }
    }
    
    public int add(int val) {
        this.heap.offer(val);
        
        while (this.heap.size() > this.k) {
            this.heap.poll();
        }

        return this.heap.peek();
    }
}
