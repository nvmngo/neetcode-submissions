class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //the intuition is, we will use backtracking to check through all of the possible situations
        //we will keeping adding the same number
            //if the sum matched the target -> add the list into the result
            //if the sum preceed the targer -> undo and check it with a different number
        List<List<Integer>> res = new LinkedList<>();

        //implement a helper method
        List<Integer> current = new ArrayList<>();
        combinationSumHelper(0, nums, target, current, 0, res);
        
        return res;
    }

    public void combinationSumHelper(int index, int[] nums, int target, List<Integer> current, int sum, List<List<Integer>> res) {
        
        if (index == nums.length) {
            return;
        }
        
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<Integer>(current));
            return;
        }
        
        // Choice 1: take nums[index]
        current.add(nums[index]);
        combinationSumHelper(index, nums, target, current, sum + nums[index], res);

        // undo
        current.remove(current.size() - 1);

        // Choice 2: skip nums[index]
        combinationSumHelper(index + 1, nums, target, current, sum, res);

    }
}
