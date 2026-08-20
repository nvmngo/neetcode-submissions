class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] A;
        int[] B;
        if (nums1.length < nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }

        int length = A.length + B.length;
        int leftPartition = length / 2;

        int l = 0;
        int r = A.length -  1;

        while (true) {
            int i = Math.floorDiv(l + r, 2); //A
            int j = leftPartition - i - 2; //B

            double aLeft = (i >= 0) ? (double)A[i] : Double.NEGATIVE_INFINITY;
            double aRight = (i + 1 < A.length) ? (double)A[i + 1] : Double.POSITIVE_INFINITY;
            double bLeft = (j >= 0) ? (double)B[j] : Double.NEGATIVE_INFINITY;
            double bRight = (j + 1 < B.length) ? (double)B[j + 1] : Double.POSITIVE_INFINITY;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (length % 2 != 0) {
                    return Math.min(aRight, bRight);
                } else {
                    return 0.5 * (Math.max(aLeft, bLeft) + Math.min(aRight, bRight));
                }
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }


    }
}



// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int length = nums1.length + nums2.length;

//         int median = (length - 1)/2;
//         int remainder = (length -1)%2;

//         double ans = 0;

        
//         int p1 = 0;
//         int p2 = 0;

//         while (median >= 0) {
            
//             if (p1 >= nums1.length) {
//                 ans = nums2[p2];
//                 p2++;
//             } else if (p2 >= nums2.length) {
//                 ans = nums1[p1];
//                 p1++;
//             }
            
//             else if (nums1[p1] < nums2[p2]) {
//                 ans = nums1[p1];
//                 p1++;
//             } else {
//                 ans = nums2[p2];
//                 p2++;
//             }
//             median --;
//         }

//         if (remainder != 0) {
//             int addition;
//             if (p1 >= nums1.length) {
//                 addition = nums2[p2];
//             } else if (p2 >= nums2.length) {
//                 addition = nums1[p1];
//             }
            
//             else if (nums1[p1] < nums2[p2]) {
//                 addition = nums1[p1];
//             } else {
//                 addition = nums2[p2];
//             }
//             ans = (ans + addition)/2;
//         }

//         return ans;
//     }
// }
