class MedianFinder {

    //The intuition for this question:
    /* 
    The recommended time complexity for this problem:
    - O(log n) -> addNum()
    - O(1) -> findMedian()

    *------BINARY SEARCH APPROACH--------*
    By seeing log(n) for addNum(), I would know for sure that we need to use
    'Binary Search' approach.
    With storing the stream of number into an 'ArrayList'
    -> this would make the time complexity for finding the median O(1) time
    

    *------HEAP APPROACH--------*
    Whenever we encounter problems asking
        "Keeping track of the middle value"
    OR to be more general
        "Keep track of the median among the stream of int"
    
    We would want to apply the use of HEAPs:
    - Splitting the stream of int into two subsets
    WHERE the first subset will store the SMALLER values
    AND the second subset will store the LARGER values

    - The data structure used for this purpose  -> HEAPs
    WHY?
    By using one 'max-heap' (for the smaller subset) and a 'min-heap' (for the counterpart)
    WHERE in the case of both heaps have the same size - approximately - then
    its easy for us to just 'peek' at the smallest and largest value of the two heaps
    -> finding the median
    */

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        //TODO
            //Initialising the 'Max-heap' - Left subset
        this.small = new PriorityQueue<>(
            Collections.reverseOrder()
        );
            //Initialising the 'Min-heap' - Right subset
        this.large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //TODO
        int max = (this.small.size() != 0) ? this.small.peek() : Integer.MAX_VALUE;

        if (num <= max) {
            this.small.offer(num);

            while (this.small.size() - this.large.size() > 1) {
                int out = this.small.poll();
                this.large.offer(out);
            }
        }

        else {
            this.large.offer(num);

            while (this.large.size() - this.small.size() > 1) {
                int out = this.large.poll();
                this.small.offer(out);
            }
        }
    }
    
    public double findMedian() {
        //TODO
        if (this.small.size() == this.large.size()) {
            return ((double) this.small.peek() + this.large.peek()) / 2;
        }
        else if (this.small.size() < this.large.size()) {
            return this.large.peek();
        }
        else {
            return this.small.peek();
        }
    }
}
