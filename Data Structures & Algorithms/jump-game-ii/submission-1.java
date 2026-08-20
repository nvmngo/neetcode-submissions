class Solution {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return dfs(0, nums, dp);
    }

    public int dfs(int pos, int[] nums, Integer[] dp) {
        //base case
        if (pos >= nums.length - 1) {
            return 0;
        }

        if (dp[pos] != null) {
            return dp[pos];
        }

        //recursive case
        int jumps = nums[pos];
        if (jumps == 0) {
            return Integer.MAX_VALUE - 1;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= jumps; i++) {
            min = Math.min(min, 1 + dfs(pos + i, nums, dp));
        }

        dp[pos] = min;
        return min;
    }
}
