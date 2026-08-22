class Solution {
    public int missingNumber(int[] nums) {
        int realSum = (nums.length) * (nums.length + 1) / 2;
        int sum = 0; 

        for (int num : nums) {
            sum += num;
        }

        return realSum - sum;
    }
}
