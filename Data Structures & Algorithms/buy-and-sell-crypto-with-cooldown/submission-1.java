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

        */

        int max = 0;
        int[] dp = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            //the special case of the ending day
            if (i == prices.length - 1) {
                dp[i] = 0;
                continue;
            }
            
            int profit = -prices[i];
            int temp = 0;
            
            //checking the possible day we can sell the coin
            for (int j = i + 1, n = prices.length; j < n; j++) {
                int temp2 = 0;
                profit += prices[j];
                
                //checking the following day we can buy
                for (int k = j + 2; k < n; k++) {
                    temp2 = Math.max(temp2, dp[k]);
                }

                temp = Math.max(temp, profit + temp2);

                profit -= prices[j];
            }

            dp[i] = temp;
            max = Math.max(max, temp);
        }

        return max;
    }
}
