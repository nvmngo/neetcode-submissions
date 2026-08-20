class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int num : nums) {
            heap.offer(num);
        }

        while (k > 1) {
            heap.poll();
            k--;
        }

        return heap.poll();
    }
}
