class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            
            if (nums[left] < nums[right]) {
                int middle = left + (right - left)/2;
                if (target == nums[middle]) {
                    return middle;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }

                continue;
            }
            
            int middle = left + (right - left)/2;

            if (target == nums[middle]) {
                return middle;
            }

            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && nums[middle] >= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] <= target && nums[right] >= target) {
                    left = middle;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
