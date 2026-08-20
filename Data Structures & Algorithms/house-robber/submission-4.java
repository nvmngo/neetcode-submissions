class Solution {
    public int rob(int[] nums) {
        //The intuition for this question:
        /* 
        O _ O O
        1 2 3 4

        This little diagram shows the different possibilities of how the robber
        can continue to rob, if, in the case of, he decided the rob '1' house
        
        -> he can either rob '3' OR '4' in order to have the maximum amount of money

        WHERE we should see '3' and '4' as the continuing starting point, and where,
        at its own starting point, will have its own MAXIMUM MONEY.

        Currently, my intuition is to use RECURSION, without any memoization

        - Use recursion to find the MAXIMUM MONEY coming from choosing '3' as the next case
        and the MAXIMUM MONEY coming from choosing '4' as the next place
        */

        int[] max = new int[nums.length];

        return Math.max(robHelper(0, nums, max), robHelper(1, nums, max));
    }

    //implement a helper method:    finding the maximum money from continuing to rob at house ith
    public int robHelper(int i, int[] nums, int[] max) {
        //base case
        if (i >= nums.length) {
            return 0;
        }

        if (max[i] != 0) {
            return max[i];
        }

        int res = Math.max(robHelper(i + 2, nums, max), robHelper(i + 3, nums, max)) + nums[i];        
        max[i] = res;

        return res;
    }

}
