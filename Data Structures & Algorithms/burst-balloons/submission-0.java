class Solution {
    public int maxCoins(int[] nums) {
        // The intuition for this question:
        /* 
        Intuitively, I will follow a 'backtracking' approach to this certain problem
         - Via backtracking, we can cover all the different situations, branches of 
         the decision tree.
         
         - Either we:
            - Pop the current balloon
            - Skip the current balloon
         WHERE:     We're in the same state (same sample size of the balloons) 

        Thus, one idea of how we should implement the cache will be
            - Using a HashMap, storing the entries of key & value pairs

            <current sample of the balloons> 
            -> <different balloon indices>
            -> <the maximum coins scored by following that pattern>

        ---------------------------------------------------------------------------

        Apparently, the backtracking approach is too inefficient, since having 
        n different options each time, and the depth of the decision tree is also n
        -> Making the time complexity to be n^n

        Caching such things would also be painful

        The more clever approach is to, divide the balloon sample into 'subsequences'
        WHERE there would only be n^2 cases of such things

        Instead of thinking, 'what balloon we're popping first' 
        -> we need to think 'what balloon we're popping last'
        */

        //Creating new array with the implicit '1's balloons
        int[] balloons = new int[nums.length + 2];
        
        balloons[0] = 1;
        balloons[balloons.length - 1] = 1;

        for (int i = 1, n = balloons.length - 1; i < n; i++) {
            balloons[i] = nums[i - 1];
        }
        
        //Cache
        Integer[][] dp = new Integer[balloons.length][balloons.length];

        return maxCoinsHelper(1, balloons.length - 2, balloons, dp);
    }

    //Implement a helper method:    find the maximum score when popping [i, j] subprob
    public int maxCoinsHelper(int left, int right, int[] balloons, Integer[][] dp) {
        //base case ------------------------------------------------------------
        if (left == right) {
            return balloons[left - 1] * balloons[left] * balloons[left + 1];
        }

        //there is no balloon to pop
        if (left > right) {
            return 0;
        }

        //if we have already visited this state
        if (dp[left][right] != null) {
            return dp[left][right];
        }

        //recursive case---------------------------------------------------------
        int max = 0;
        for (int i = left; i <= right; i++) {
            int res = balloons[left - 1] * balloons[i] * balloons[right + 1]
                        + maxCoinsHelper(left, i - 1, balloons, dp) 
                        + maxCoinsHelper(i + 1, right, balloons, dp);
            max = Math.max(res, max);
        }

        dp[left][right] = max;
        return max; 
    }
}
