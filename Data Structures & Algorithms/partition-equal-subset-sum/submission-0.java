class Solution {
    public boolean canPartition(int[] nums) {
        //The intuition for this question:
        /* 
        Approach this question with backtracking:

        - The array can only be partitioned into two same sum subsets
        ONLY and ONLY IF
            - The sum of all the number is 'even'
            - IF the sum is 'odd' -> RETURN FALSE
        
        - What we'll need to find:
            - Find a subset that have the sum = total sum / 2

        - Iterate through each of the number
            - choose WHETHER we'll TAKE this number in the subset
            OR we'll SKIP it
                - We can only take the number IF (sum + num <= goal)
                - If the subset's sum > goal -> Ignore the current number

        - After finishing the whole iteration without any TRUE result
            - Return FALSE
        
        - Can use a 'cache' storing the result of the subset starting at 'i'
        dp[i] = true/false
        */

        HashMap<Integer, Boolean> cache = new HashMap<>();
        
        //checking whether the total sum is EVEN
        int goal = 0;
        for (int num : nums) {
            goal += num;
        }

        if (goal % 2 != 0) { return false; }

        goal = goal / 2;

        int sum = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            if (canPartitionHelper(i, nums, 0, goal, cache)) { return true; }
        }

        return false;
    }

    //implement a helper method:    Visiting every possible subsets
    public boolean canPartitionHelper(int index, int[] nums, int sum, int goal, HashMap<Integer, Boolean> cache) {
        //base case
        if (index == nums.length) { return false; }
        
        if (sum == 0 && cache.containsKey(nums[index])) {
            return cache.get(nums[index]);
        }

        //recursive case
            //taking the number
        if (sum + nums[index] == goal) {
            if (sum == 0) {
                cache.put(nums[index], true);
            }
            return true;
        }

        if (sum + nums[index] < goal) {
            if (canPartitionHelper(index + 1, nums, sum + nums[index], goal, cache) == true) {
                if (sum == 0) {
                    cache.put(nums[index], true);
                }
                return true;
            }
        }

        if (canPartitionHelper(index + 1, nums, sum, goal, cache) == true) {
            if (sum == 0) {
                cache.put(nums[index], true);
            }
            return true;
        }

        if (sum == 0) {
            cache.put(nums[index], false);
        }

        return false;
    }
}
