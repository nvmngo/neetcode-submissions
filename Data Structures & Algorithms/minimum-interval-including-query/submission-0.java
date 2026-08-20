class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        //sorting the intervals 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //creating the returning query array
        int[] res = new int[queries.length];

        //looping through each of the query
        for (int i = 0, n = queries.length; i < n; i++) {
            int num = queries[i];
            int min = Integer.MAX_VALUE;

            for (int[] interval : intervals) {
                if (interval[0] > num) {
                    break;
                }

                if (num >= interval[0] && num <= interval[1]) {
                    min = Math.min(min, interval[1] - interval[0] + 1);
                }
            }

            if (min == Integer.MAX_VALUE) { res[i] = -1; }
            else {
                res[i] = min;
            }
        }

        return res;
    }
}
