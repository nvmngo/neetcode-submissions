class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> sorted = new ArrayList<>();

        //add in the intervals that is NOT AFFECTED by the newInterval
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            sorted.add(intervals[i]);
            i++;
        }

        //merge all the intervals that is overlapped
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        sorted.add(newInterval);
        //add all the remaining intervals
        while (i < intervals.length) {
            sorted.add(intervals[i]);
            i++;
        }

        int[][] res = new int[sorted.size()][2];
        for (int j = 0, n = sorted.size(); j < n; j++) {
            res[j] = sorted.get(j);
        }

        return res;
    }
}
