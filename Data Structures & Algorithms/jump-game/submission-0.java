class Solution {
    public boolean canJump(int[] nums) {
        //implementing a cache
        Boolean[] dp = new Boolean[nums.length];

        return helper(0, nums, dp);
    }

    //Implement a helper method:    determining whether we can reach the end in this pos
    public boolean helper(int pos, int[] nums, Boolean[] dp) {
        //base case
        if (pos >= nums.length) {
            return false;
        }

        if (pos == nums.length - 1) {
            return true;
        }

        if (dp[pos] != null) {
            return dp[pos];
        }

        //recursive case
        int jumps = nums[pos];

        for (int i = 1; i <= jumps; i++) {
            if (helper(pos + i, nums, dp) == true) {
                return true;
            }
        }

        dp[pos] = false;
        return false;
    }
}
