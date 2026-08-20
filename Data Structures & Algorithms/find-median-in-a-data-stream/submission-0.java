class MedianFinder {

    //The intuition for this question:
    /* 
    The recommended time complexity for this problem:
    - O(log n) -> addNum()
    - O(1) -> findMedian()

    By seeing log(n) for addNum(), I would know for sure that we need to use
    'Binary Search' approach.
    With storing the stream of number into an 'ArrayList'
    -> this would make the time complexity for finding the median O(1) time
    
    */

    private ArrayList<Integer> stream;

    public MedianFinder() {
        this.stream = new ArrayList<>();
    }
    
    public void addNum(int num) {
        //Algorithm for searching and inserting a value in
        int l = 0;
        int r = this.stream.size() - 1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (num > this.stream.get(m)) {
                l = m + 1;
            } else {
                r = m - 1; 
            }
        }

        //adding based on the index of 'l'
        this.stream.add(l, num);
    }
    
    public double findMedian() {
        
        int size = this.stream.size();
        
        if (size % 2 == 0) {
            return ((double) this.stream.get((size -1)/2) + this.stream.get((size-1)/2 + 1))/2;
        } else {
            return (double) this.stream.get(size/2);
        }
    }
}
