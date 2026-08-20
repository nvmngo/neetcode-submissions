class Solution {
    public int change(int amount, int[] coins) {
        //The intuition for this question:
        /* 
        We will follow this thinking pathway in order to solve the problem:
            Brute Force - Cache - Dynamic Programming
        

        ---- The Brute Force approach : Backtracking ----
        
        - My very first intuition is to use the backtracking algorithm to solve
        the problem.
        - At the any current index/coin: 
            - We can either - USE the coin
                            - IGNORE the coin
            - If we USE the coin:  
                - Increment the total sum
                - And can either use the coin again or ignore it

        - We will explore & backtrack to different 'states', where each of them
        is defined by:
            - the current sum of the coins
            - the current considering coin

        - Thus, in order to avoid duplicates work of the same state
            -> Cache:   dp[i][j] = the number total number of ways 
                                   the current sum 'i' can be added up to 
                                   the goal when we're currently considering 
                                   coin 'j'
        

        *** ---- *** ---- ** The algorithm ** ---- *** ---- ***:
        - Implement a helper backtracking method:
            - Perform normal backtracking recursion work
            - Though, keep track of the visited states
        - IF a state is not yet been visited:
            - Explore the possible paths
            - Once get the result -> update it to be visited
        */

        Integer[][] dp = new Integer[amount][coins.length];

        return changeHelper(0, coins, 0, dp);
    }

    public int changeHelper(int index, int[] coins, int sum, Integer[][]dp) {
        //base case
        if (index == coins.length) {
            return 0;
        }

        if (sum > dp.length) {
            return 0;
        }

        if (sum == dp.length) {
            return 1;
        }

        if (dp[sum][index] != null) {
            return dp[sum][index];
        }

        //recursive case
        //Case 1: take the current coin
        int take = changeHelper(index, coins, sum + coins[index], dp);
        //Case 2: skip the current coin
        int skip = changeHelper(index + 1, coins, sum, dp);

        dp[sum][index] = take + skip;
        return take + skip;
    }
}
