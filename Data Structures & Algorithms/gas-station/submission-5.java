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
        
        int balance = 0;
        boolean startLoop = false;
        int start = 0;

        for (int i = 0; i < res.length; i++) {
            if (!startLoop && res[i] < 0) { continue; }
            else if (!startLoop) {
                startLoop = true;
                start = i;
                balance = res[i];
                continue;
            }

            balance += res[i];

            if (balance < 0) {
                startLoop = false;
                balance = 0;
            }
        }

        return start; 
    }
}
