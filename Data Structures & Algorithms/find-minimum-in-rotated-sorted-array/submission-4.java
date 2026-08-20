class Solution {
    public int findMin(int[] nums) {
        //search for the minimum number
        //using binary search
        //the hard thing is, how can we know where to narrow down

        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];

        while (left <= right) {
            
            //try to narrow down the range of position that the min value could be
            //a rotated sorted array would have an sorted part, and unsorted part

            //if the whole thing is sorted then, we can just take the first value

            //else, see whether the right or left is sorted, then narrow the range into the unsorted side
            
            //continue the procedure then we would have a number that caused that unsorted order

            if (nums[left] < nums[right]) { //check for the first iteration, whether the whole thing is sorted
                ans = Math.min(ans, nums[left]);
                break;
            }

            int middle = left + ((right - left)/2);
            ans = Math.min(nums[middle], ans);

            if (nums[left] < nums[middle]) {
                left = middle + 1;
            } else if (nums[left] > nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return ans;
    }
}
