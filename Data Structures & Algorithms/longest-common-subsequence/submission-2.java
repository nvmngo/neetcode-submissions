class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //The intuition for this question:
        /* 
        ------- Brute Force approach: -------
        - Compare the length of the two Strings
            - Store the string with the 'shorter' length
        - Get all the possible subsequence within that String
            - For each of the subsequence:
                - IF exists the subsequence in the longer string, STORE
                that 'length' value
                - Keep track of the longest subsequence length

        - However, by this, exists duplicate work, for example:
            - if the subsequence 'ca' does not exists in the longer string
            -> there is no need for us to continue down the path of that subsequence

        -> Once a subsequence path DOES NOT exists, return 0.

        IN DP:  aware of the state/situation -> avoid duplicate works
        The definition for each of my state:
            - Finding the maximum common subsequence
            Starting with the letter at index i + and searching from the index j of the longer string

            dp[i][j] = the maximum common subsequence
                       WHERE the subsequence starting from the character at index 'i' of the shorter string
                       AND searching from the character at index 'j' of the longer string
        */

        String shorter = text1;
        String longer = text2;
        if (text2.length() < text1.length()) {
            shorter = text2;
            longer = text1;
        }

        Integer[][] dp = new Integer[shorter.length()][longer.length()];

        return helper(0, 0, shorter, longer, dp);

    }

    public int helper(int index, int start, String shorter, String longer, Integer[][] dp) {
        
        //base case
        if (index == shorter.length() || start == longer.length()) {
            return 0;
        }

        if (dp[index][start] != null) {
            return dp[index][start];
        }

        //recursive case
        //CASE 1: skip the current index
        int skip = helper(index + 1, start, shorter, longer, dp);

        //CASE 2: take the current index IF the longer string have that
        int take = 0;
        for (int i = start, n = longer.length(); i < n; i++) {
            if (shorter.charAt(index) == longer.charAt(i)) {
                take = 1 + helper(index + 1, i + 1, shorter, longer, dp);
                break;
            }
        }

        int max = Math.max(skip, take);
        dp[index][start] = max;
        return max;
    
    }
}
