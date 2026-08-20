class Solution {
    public boolean hasDuplicate(int[] nums) {
        java.util.ArrayList<Integer> distinctNums = new ArrayList<>();

        for (int i : nums) {
            if (distinctNums.contains(i)) {
                return true;
            }
            else {
                distinctNums.add(i);
            }
        }
        return false;
    }
}