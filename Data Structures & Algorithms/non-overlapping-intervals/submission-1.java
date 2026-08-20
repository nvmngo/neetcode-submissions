class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Sorting the intervals by their starting index
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        //counting tracker && pointer for current considering interval
        int count = 0;
        
        int l = 0;
        int r = 1;

        //iterating through the element to count the overlapping intervals
        while (r < intervals.length) {
            int[] curr = intervals[l];
            int[] next = intervals[r];

            //if overlapping
            if (curr[1] > next[0]) {
                count++;
                r++;
            } else {
                l = r;
                r++;
            }
        }

        //return count
        return count;
    }
}
