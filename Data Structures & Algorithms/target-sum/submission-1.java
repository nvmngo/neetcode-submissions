class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //The algorithm for this question:
        /* 
        - Use backtracking algorithm as the spine for solving this problem
            - WHERE, at each position, you can either ADD or SUBTRACT
        
        - We're visiting & exploring different states, WHERE, a state can be
        defined by:
            - The current sum
            - The current nums index
        
        - Thus, implement a cache, storing the possible number of ways we can
        achieve the goal at different states
            - dp[i][j] = the number of ways where in the state of:
                            - total sum 'i'
                            - current index 'j'
        */

        HashMap<Integer, HashMap<Integer, Integer>> hashMap = new HashMap<>();

        return helper(0, nums, 0, target, hashMap);
    }

    public int helper(
        int index,
        int[] nums,
        int sum,
        int target,
        HashMap<Integer, HashMap<Integer, Integer>> hashMap
    ) {
        //base case
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        if (hashMap.containsKey(sum) && hashMap.get(sum).containsKey(index)) {
            return hashMap.get(sum).get(index);
        }

        //recursion case
        //Case 1: Add the current num into the sum
        int add = helper(index + 1, nums, sum + nums[index], target, hashMap);
        //Case 2: Subtract the current sum of the sum
        int subtract = helper(index + 1, nums, sum - nums[index], target, hashMap);

        if (!hashMap.containsKey(sum)) {
            hashMap.put(sum, new HashMap<Integer, Integer>());
        }
        hashMap.get(sum).put(index, add + subtract);

        return add + subtract;
    }
}
