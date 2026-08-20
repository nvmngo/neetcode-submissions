class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //declaring the result list
        List<List<Integer>> res = new LinkedList<>();

        //the intution is, we will store all the un-used numbers
        //and each of the position (each case) will use one of that un-used number
        //if the un-used number list is empty -> store the permutation into the result
            //which then we will backtrack, and use a different number for that permutation

        //creating an un-used list 
        LinkedList<Integer> unused = new LinkedList<>();
        for (int num : nums) {
            unused.offer(num);
        }

        List<Integer> current = new ArrayList<>();
        permuteHelper(unused, current, res);

        return res;
    }

    //implement a helper class
    public void permuteHelper(LinkedList<Integer> unused, List<Integer> current, List<List<Integer>> res) {
        
        //base case
        if (unused.size() == 0) {
            //creating a copy
            res.add(new ArrayList<Integer>(current));
            return;
        }

        //the intuition here is, at each situation (where a situation is defined by the unused numbers)
        //we have the options of trying all the possible numbers of un-used
        //each of the number will be one option that we would choose

        for (int i = 0, n = unused.size(); i < n; i++) {
            //Step A:   adding this option number to the list
            Integer usedNum = unused.remove(i);
            current.add(usedNum);

            //Step B:   explore the path in this situation
            permuteHelper(unused, current, res);

            //Step C:   undoing everything
            unused.add(i, usedNum);
            current.remove(current.size() - 1);
        }
    }
}
