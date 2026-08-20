class Solution {
    public int rob(int[] nums) {
        //The intuition for this question
        /* 
        This question will follow the same approach as the previous question - House Robber I

        But in stead of straight up calculating the maximum amount of money
        -> We need to be aware that:
            - IF the robber's starting robbing the first house
                -> The final house can not be robbed

        Basically, then, we will follow the same approach
        - Max money at ith = Max of : (Max Money at i + 2) 
                                    OR (Max Moeny at i + 3)
                            + money at i
        - However, if we're starting at '0'
        -> The final house will not be included in the array
        */

        if (nums.length == 1) return nums[0];

        int[] maxOne = new int[nums.length - 1];
        int[] maxTwo = new int[nums.length];

        Arrays.fill(maxOne, -1);
        Arrays.fill(maxTwo, -1);

        int[] numsOne = Arrays.copyOfRange(nums, 0, nums.length - 1);

        return Math.max(Math.max(robHelper(0, numsOne, maxOne), robHelper(1, nums, maxTwo)), robHelper(2, nums, maxTwo));
    }

    public int robHelper(int i, int[] nums, int[] max) {
        //base case
        if (i >= nums.length) {
            return 0;
        }

        if (max[i] != -1) {
            return max[i];
        }

        int res = Math.max(robHelper(i + 2, nums, max), robHelper(i + 3, nums, max)) + nums[i];
        max[i] = res;

        return res;
    }
}
