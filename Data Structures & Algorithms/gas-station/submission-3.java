class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // The intuition for this question:
        /* 
        The brute force idea is maybe to try going through every different 
        station that we're having

        The time complexity: O(n^2) -> iterating n times for each of the stations
        */

        int[] res = new int[gas.length];
        int sum = 0;
        for (int i = 0, n = gas.length; i < n; i++) {
            res[i] = gas[i] - cost[i];
            sum += res[i];
        }

        if (sum < 0) return -1;

        int start = 0;
        while (res[start] < 0) {
            start++;
        }

        return helper(start, res);
    }

    public int helper(int start, int[] res) {
        int iterations = res.length;
        int balance = res[start];

        if (balance < 0) {
            if (start == res.length - 1) { return helper(0, res); }
            return helper(start + 1, res);
        }

        int i = start;

        while (iterations > 0) {
            if (i == res.length - 1) {
                i = 0;
                balance += res[0];
            } else {
                i++;
                balance += res[i];
            }

            if (balance < 0) {
                if (i == res.length - 1) { return helper(0, res); }
                return helper(i + 1, res);
            }

            iterations--;
        }

        return start;
    }
}
