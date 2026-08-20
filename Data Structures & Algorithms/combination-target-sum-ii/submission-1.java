class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();  
        
        //the intuition for this problem is quite similar to Combination Sum I
        //where now i can just go through all of the situation, deciding to whether add or no add the current index
        //where the situation is defined by the before candidates, and the current index

        List<Integer> current = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSumHelper(0, candidates, target, current, 0, res);
        
        return res;
    }

    public void combinationSumHelper(int index, int[] candidates, int target, List<Integer> current, int sum, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new LinkedList<Integer>(current));
            return;
        }
        
        if (index == candidates.length || sum > target) {
            return;
        }

        //Choice 1: add the current index
        
        current.add(candidates[index]);
        combinationSumHelper(index + 1, candidates, target, current, sum + candidates[index], res);

        //Choice 2: skip all the similar number
        current.remove(current.size() - 1);

        int nextIndex = index;
        while (candidates[nextIndex] == candidates[index]) {
            nextIndex++;
            
            if (nextIndex == candidates.length) {
                return;
            }
        }

        combinationSumHelper(nextIndex, candidates, target, current, sum, res);
    }
}
