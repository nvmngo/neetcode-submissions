class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //declaring the returning list
        List<List<Integer>> res = new LinkedList<>();
        
        //the intuition is, think of backtracking as a DFS question, where at each situation, we would have 2 different options
        //a situation will be defined by the two possible options (basically the added number), and the current list that we're having
        //for every situation, we will go through both of the options, add them in first, then undo it, then choose the other option of not adding them in

        List<Integer> current = new ArrayList<>();

        //implement a helper function, handling the recursion
        subsetsHelper(res, current, 0, nums);
        return res;
    }

    public void subsetsHelper(List<List<Integer>> res, List<Integer> current, int index, int[] nums) {
        //base case
            //the intuition is we will searching until we reach the endpoint of the nums
        if (index == nums.length) {
            ArrayList<Integer> ele = new ArrayList<>();
            ele.addAll(current);
            res.add(ele);
            return;
        }

        //the first option, adding the number into the list
        current.add(nums[index]);
        subsetsHelper(res, current, index + 1, nums);
        //the second option, not adding the number into the list
        current.remove(current.size() - 1); //removing the last added number
        subsetsHelper(res, current, index + 1, nums);
    }
}
