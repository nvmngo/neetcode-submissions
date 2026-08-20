class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        //The intuition for this question
        /* 
        The minimum cost for one to reach the top floor
        = Minimum cost of (
            Taking the stairs from (top - 1) floor
        OR  Taking the stairs from (top - 2) floor
        )

        Taking the 'Recursion' + 'Memoization' approach:
        - Finding and storing the minimum cost to floor n^th
            - WHERE n - any given integer (n < cost.length)
        */ 

        int[] minCost = new int[cost.length];
        
        for (int i = 0; i < cost.length; i++) {
            if (i == 0 || i == 1) {
                minCost[i] = 0;
            } else {
                minCost[i] = Math.min(minCost[i - 1] + cost[i -1], minCost[i - 2] + cost[i - 2]);
            }
        }

        int top = cost.length;
        return Math.min(minCost[top - 1] + cost[top - 1], minCost[top - 2] + cost[top - 2]);
    }
}
