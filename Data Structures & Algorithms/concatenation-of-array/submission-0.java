class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];

        int l = nums.length;

        for (int i = 0, n = nums.length * 2; i < n; i++) {
            if (i < l) {
                res[i] = nums[i];
            }

            else {
                res[i] = nums[i - l];
            }
        }

        return res;
    }
}