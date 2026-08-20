class Solution {
    public int maxSubArray(int[] nums) {
        // The intuition for this question:
        /* 
        Each position of the array, where exists a subarray starting from that position,
        will have its own maximum subarray sum.

        and the maximum subarray sum starting from index i
        = nums[i] + maxSum[i + 1]

        and via the value of maxSum[i + 1], we can determine WHETHER we should extend the
        subarray to i, or let i be the new considered subarray

        The algorithm for the problem:------------------------------------------------

        - Create a cache, storing the maximum subarray sum starting from each position
        - Starting from the final index:
            - The maxSum[ final ] = final
        - Continue to decrement the index, considering the current index = 'i':
            - IF (maxSum[i + 1] < 0):   
                - maxSum[i] = nums[i]
            - ELSE:
                - maxSum[i] = nums[i] + maxSum[i + 1]
        - Simultaneously keeping track of the maximum sum

        - Return the final maximum sum
        */

        int[] dp = new int[nums.length];
        int max = nums[0];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                dp[i] = nums[i];
                max = Math.max(max, dp[i]);
                continue;
            }

            dp[i] = nums[i];

            if (dp[i + 1] > 0) {
                dp[i] += dp[i + 1];
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
