class Solution {
    public int maxProduct(int[] nums) {
        //The intuition for this question:
        /* 
        The maximum product strongly depends on the 'number of NEGATIVEs'
        within the array.

        Since the more positive number we multiply with -> the larger the product
        (positive = negative + 0)

        When we multiply the current product with a negative,
            its only making sense to continue to multiply
            IF the following numbers contains a negative
        
        ---------- OR, we can think of it like this way ---------------
        
        dp[i] = the maximum product, of the subarray from index i -> end
        => dp[i - 1] = [i - 1] * dp[i]

        some sort like that
        */

        //Tracking the maximum value
        int max = Integer.MIN_VALUE;
        //Memoization
        int[][] dp = new int[nums.length][2];

        //iterating through the array
        for (int i = nums.length - 1; i >= 0; i--) {
            
            int num = nums[i];
            
            //base case of dp
            if (i == nums.length - 1) {
                if (num < 0) {
                    dp[i] = new int[]{1, num};
                } else if (num > 0) {
                    dp[i] = new int[]{num, 1};
                } else {
                    dp[i] = new int[]{1, 1};
                }

                max = Math.max(max, num);
                continue;
            }

            //Positive number
            if (num > 0) {
                //TODO
                if (dp[i + 1][1] == 1) {
                    dp[i] = new int[]{num * dp[i + 1][0], 1};
                } else if (dp[i + 1][1] < 0) {
                    dp[i] = new int[]{num * dp[i + 1][0], num * dp[i + 1][1]};
                }

                max = Math.max(dp[i][0], max);
            }

            //Negative number
            else if (num < 0) {
                //TODO
                if (dp[i + 1][1] == 1) {
                    dp[i] = new int[]{1, num * dp[i + 1][0]};

                    max = Math.max(max, num);

                } else if (dp[i + 1][1] < 0) {
                    dp[i] = new int[]{
                        num * dp[i + 1][1], // negative × negative = maximum positive
                        num * dp[i + 1][0]  // negative × positive = minimum negative
                    };

                    max = Math.max(dp[i][0], max);
                }
            }

            //Zero
            else {
                dp[i] = new int[]{1, 1};
                max = Math.max(0, max);
            }

        }   

        return max;

    }
}
