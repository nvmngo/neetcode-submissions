class Solution {
    public int numDistinct(String s, String t) {
        // The intuition for this question
        /* 
        This problem will require a quite similar approach to the other question:
        -- Using backtracking algorithm to find the different number of subsequences
        -- With the help of a cache, storing the different subsequences of certain
        states.

            dp[i][j] = the number of distinct subsequences
                - STARTING FROM 'i'th index of string 's'
                - WHERE the character at 'i'th index of 's'
                        == the character at 'j'th index of 't'
        */

        Integer[][] dp = new Integer[s.length()][t.length()];

        return helper(0, 0, s, t, dp);

    }

    //implement a helper function:  Finding the different subsequences starting 'i'
    public int helper(int i, int j, String s, String t, Integer[][] dp) {
        //base case
        if (j == t.length()) {
            return 1;
        }
        
        if (i == s.length()) {
            return 0;
        }

        //recursive case
        int sum = 0;

        for (int o = i, n = s.length(); o < n; o++) {
            if (s.charAt(o) == t.charAt(j)) {
                //if in cache
                if (dp[o][j] != null) {
                    sum += dp[o][j];
                    continue;
                }

                //otherwise
                int distinct = helper(o + 1, j + 1, s, t, dp);
                sum += distinct;
                dp[o][j] = distinct;
            }
        }

        return sum;
    }
}
