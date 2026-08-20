class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0, n = nums.length; i < n - 1; i ++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return 0;
    }
}
