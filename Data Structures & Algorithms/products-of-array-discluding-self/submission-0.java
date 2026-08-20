class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int product = 1;
        int count = 0;

        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                product *= num;
            }
        }

        for (int i = 0, n = nums.length; i < n; i++) {
            if (count == 0) {
                result[i] = product / nums[i];
            } else if (count == 1) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}  
