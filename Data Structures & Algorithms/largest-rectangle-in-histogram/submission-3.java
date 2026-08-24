class Solution {
    public int largestRectangleArea(int[] heights) {
        // The intuition for this question:
        /* 
            Mainly focusing on the implementation of STACK
            -> adding all the HEIGHTS -> UNTIL a smaller height is observed
            -> by this -> maximum area might be worse -> start calculating the
            maximum area starting from prev highest node
            -> work the way down to the smaller one
        */
        
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0, n = heights.length; i < n; i++) {
            int start = i;  

            // start popping
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {  // smaller height
                int[] prev = stack.pop();

                start = prev[0];    // trying to extend the smaller height width 

                maxArea = Math.max(maxArea, (i - start) * prev[1]); // multiplying with the larger height -> giving the largest possible area with the larger height

            }

            stack.push(new int[]{start, heights[i]});
        }

        // one last verification
        while (!stack.isEmpty()) {
            int[] prev = stack.pop();

            maxArea = Math.max(maxArea, prev[1] * (heights.length - prev[0]));
        }

        return maxArea;
    }
}
