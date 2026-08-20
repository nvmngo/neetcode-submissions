class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        int median = (length - 1)/2;
        int remainder = (length -1)%2;

        double ans = 0;

        
        int p1 = 0;
        int p2 = 0;

        while (median >= 0) {
            
            if (p1 >= nums1.length) {
                ans = nums2[p2];
                p2++;
            } else if (p2 >= nums2.length) {
                ans = nums1[p1];
                p1++;
            }
            
            else if (nums1[p1] < nums2[p2]) {
                ans = nums1[p1];
                p1++;
            } else {
                ans = nums2[p2];
                p2++;
            }
            median --;
        }

        if (remainder != 0) {
            int addition;
            if (p1 >= nums1.length) {
                addition = nums2[p2];
            } else if (p2 >= nums2.length) {
                addition = nums1[p1];
            }
            
            else if (nums1[p1] < nums2[p2]) {
                addition = nums1[p1];
            } else {
                addition = nums2[p2];
            }
            ans = (ans + addition)/2;
        }

        return ans;
    }
}
