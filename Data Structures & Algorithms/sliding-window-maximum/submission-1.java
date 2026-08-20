class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        int l = 0;
        int r = k - 1;

        int max = nums[0];
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        res[0] = max;

        l++;
        r++;

        while (r < nums.length) {
            if (nums[r] > max) {
                max = nums[r];
            }

            else if (nums[l - 1] == max) {
                max = nums[l];
                for (int i = l; i <= r; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }
            }

            res[l] = max;
            r++;
            l++;
        }   

        return res;
    }
}
