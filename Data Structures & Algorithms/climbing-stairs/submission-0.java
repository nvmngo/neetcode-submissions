class Solution {
    public int climbStairs(int n) {
        //The intuition for this question
        /*
        At stairs n^th, all the possible options we have to get there

        = all the possible options && taking step-of-1 from (n-1)
            + all the possible options && taking a step-of-2 from (n - 2)
        
        --------------------
        ** The algorithm **
        --------------------
        - Store the 'number of possible paths' to get to floor i^th, inside an
        array.
        WHERE i is any given index

        - Iterate from '1' -> 'n'
            - Finding the 'number of possible paths' of those given floors
        
        - Return array[n - 1]
        */

        int[] ways = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                ways[i] = 1;
            } else {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
        }

        return ways[n];
    }
}
