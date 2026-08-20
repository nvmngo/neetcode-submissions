class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length == 1) {
            return 0;
        }

        int left = 0;
        int right = left + 1;

        int max = 0;

        while (right < prices.length) {
            
            if (prices[right] < prices[left]) {
                left = right;
                right++;
                continue;
            }

            int profit = prices[right] - prices[left];
            if (profit > max) {
                max = profit;
            }

            right++;
        }

        return max;
    }
}
