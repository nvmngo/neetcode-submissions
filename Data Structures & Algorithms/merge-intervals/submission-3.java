class Solution {
    public int[][] merge(int[][] intervals) {
        //Sorting the array based on the starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] curr = intervals[0];

        for (int i = 1, n = intervals.length; i < n; i++) {
            int[] next = intervals[i];

            //if overlapping
            if (curr[1] >= next[0]) {
                int[] combined = new int[]{curr[0], Math.max(curr[1], next[1])};
                curr = combined;
            } else {
                merged.add(curr);
                curr = next;
            }
        }

        merged.add(curr);
        int[][] res = new int[merged.size()][2];

        for (int i = 0, n = merged.size(); i < n; i++) {
            res[i] = merged.get(i);
        }

        return res;
    }
}
