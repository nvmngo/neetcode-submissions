class Solution {
    public int trap(int[] height) {
        /*
        the intuitive thinking for this question:
        
        - For every position of the array, the amount of water that can
        be trapped depends on the left and right boundary, and its height

        - The water would only be trapped when there is a boundary between
        them

        - and the amount of water would depends on the height of the boundary,
        the higher the height, the more water can be stored, and also the height
        at the current position

        => the amount of water at a certain position 
           = the lower height of the left and right boundary - the height of the current position
      
        */

        //to find the left and right boundary of each position
        //would need to iterate through the whole array
        //Thus, to avoid O(n^2), scanning through the array for each turn of the index
        //we would iterate through it once, and use it for future purpose

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        //finding maxLeft
        int max = 0;
        for (int i = 0, n = height.length; i < n; i++) {
            if (i == 0) {
                maxLeft[0] = 0;
                continue;
            }

            if (height[i-1] > max) {
                max = height[i - 1];
            }

            maxLeft[i] = max;
        }
        
        //finding maxRight
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                maxRight[i] = 0;
                continue;
            }

            if (height[i + 1] > max) {
                max = height[i + 1];
            }

            maxRight[i] = max;
        }

        int sum = 0;
        for (int i = 0, n = height.length - 1; i < n; i++) {
            
            int add = Math.min(maxLeft[i], maxRight[i]) - height[i];

            sum += (add < 0) ? 0 : add;
        }   

        return sum;

    }
}
