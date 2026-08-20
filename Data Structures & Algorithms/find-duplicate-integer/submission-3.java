class Solution {
    public int findDuplicate(int[] nums) {
        
        // the array contains n + 1 integers, each of the ints in nums is in
        //the range of [1, n] inclusive    

        // thus, each of the value inside the array, can be the pointer to the next index

        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) { break; }
        }

        int newSlow = nums[0];

        while (newSlow != slow) {
            newSlow = nums[newSlow];
            slow = nums[slow];
        }

        return slow;
    }
}
