class Solution {
    public int lengthOfLIS(int[] nums) {
        //The intuition for this question:
        /* 
        dp[i] = the length of the LONGEST subsequence ending at index 'i'

        for any given index 'j' having the num value LARGER than at 'i'
        dp[j] = dp[i] + 1;
        */

        int max = 1;
        int[] dp = new int[nums.length];

        for (int i = 0, n = nums.length; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
                continue;
            }

            int local = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    local = Math.max(local, 1 + dp[j]);
                }
            }

            dp[i] = local;
            max = Math.max(max, local);
        }

        return max;
    }
}
