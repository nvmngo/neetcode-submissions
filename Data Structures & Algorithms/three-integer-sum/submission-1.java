class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0, n = nums.length; i < n; i++) {
            
            int target = -nums[i];
            int l = i + 1;
            int r = n - 1;

            if (i > 0 && i < r && nums[i] == nums[i-1]) { continue; }

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    List<Integer> ele = new ArrayList<>();
                    ele.add(nums[i]);
                    ele.add(nums[l]);
                    ele.add(nums[r]);
                    res.add(ele);
                    l++;
                    r--;

                    //skip the continue dups
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
