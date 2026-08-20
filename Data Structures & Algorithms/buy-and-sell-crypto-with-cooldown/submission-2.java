class Solution {
    public int maxProfit(int[] prices) {
        //The intuition for this question:
        /* 
        We'll try to follow this framework in order to solve the problem:
            Brute Force -> Cache -> Dp
        
        The very first Brute Force thinking:
        - Find the maximum profit when buying the coin at day 'i'
        (Meaning, finding the value for every given day)

            - Once, we buy the coin on day 'i^th'
                - We can EITHER sell the coin on day 'i + 1 th' or NOT
                Following, with following day

            - After we sell the coin, 
                - Add with the maximum profit from buying and selling it 
                starting the following dayS 
        
        For now, what I'm reckoning is using a 1-D approach
        dp[i] = maximum profit if we buy the coin on day i^th

        AND using the bottom-up approach, finding it from the ending day til the starting day

        // THE INTUITION FOR 2-DP:
        dp[i][j] = the maximum profit from BUYING or SELLING at index 'i' 
                   (j = 0 -> buy | j = 1 -> sell)

        */

        int max = 0;

        int size = prices.length;
        int[][] dp = new int[size][2];

        for (int i = size - 1; i >= 0; i--) {
            //for first case
            if (i == size - 1) {
                dp[i][0] = 0;
                dp[i][1] = prices[i];
                continue;
            }

            int profit = 0;
            int profit2 = prices[i];
            for (int j = i + 1; j < size; j++) {
                profit = Math.max(profit, -prices[i] + dp[j][1]);

                if (j != i + 1) {
                    profit2 = Math.max(profit2, prices[i] + dp[j][0]);
                }
            }

            dp[i][0] = profit;
            dp[i][1] = profit2;

            max = Math.max(profit, max);
        }

        return max;
    }
}
