class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        //Declaring the return result
        List<List<Integer>> res = new LinkedList<>();

        //the intuition is quite similar to "combination sum II"
            //we will first SORT the array
            //then we will go through each of the index (each situation)
            //where a situation is defined by the current list, and the considering number
        
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        subsetHelper(nums, 0, current, res);
        return res;
    }

    //implement a helper method
    public void subsetHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> res) {

        //base case
        if (index == nums.length) {
            //adding a new copy of current
            res.add(new ArrayList<>(current));
            return;
        }

        //Choice 1: adding the current number
        current.add(nums[index]);
        subsetHelper(nums, index + 1, current, res);

        //undo
        current.remove(current.size() - 1);

        //Choice 2: skip the current number (and all the following dup number)
        int newIndex = index;
        while (newIndex < nums.length) {
            if (nums[index] == nums[newIndex]) newIndex++;
            else break;
        }
        subsetHelper(nums, newIndex, current, res);
    }
}
