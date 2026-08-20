class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left <= right) {
            int area;
            if (heights[left] > heights[right]) {   
                area = heights[right] * (right - left);
                right--;
            } else  {
                area = heights[left] * (right - left);
                left++;
            }

            if (area > max) {
                max = area;
            }
        }

        return max;
               
    }
}