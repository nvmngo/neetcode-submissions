class Solution {
    public int minDistance(String word1, String word2) {
        //The intuition for this question
        /* 
        Initially giving the starting index of two words, 0 and 0

        - Simultaneously increment the two indices:
            - IF the two character at the two indices of the two words EQUALS
                - ignore -> continue to increment
            
            - ELSE (meaning the chars are different), we will have three operation
            options:
                - REMOVE the current char
                - REPLACE the current char with the matching char
                - INSERT the matching char
            - Get the options that will return the minimum operations made
        
        - Implement a cache
            dp[i][j] = the number of operations made with
                        the substring starting from i
                    AND the substring starting from j
        */

        Integer[][] dp = new Integer[word1.length()][word2.length()];

        return helper(0, 0, word1, word2, dp);
    }

    //Implement a helper method:   finding the minimum operation at each state
    public int helper(int i, int j, String word1, String word2, Integer[][] dp) {
        //base case
        if (j == word2.length()) {
            if (i >= word1.length()) {
                return 0;
            } else {
                //deleting all the excess characters
                return word1.length() - i;
            }
        }

        if (i >= word1.length()) {
            //inserting the corresponding character
            return word2.length() - j;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        //recursive case
        if (word1.charAt(i) == word2.charAt(j)) {
            int min = helper(i + 1, j + 1, word1, word2, dp);
            dp[i][j] = min;
            return min;
        }

        int insert = helper(i, j + 1, word1, word2, dp);
        int delete = helper(i + 1, j, word1, word2, dp);
        int replace = helper(i + 1, j + 1, word1, word2, dp);

        int min = 1 + Math.min(insert, Math.min(delete, replace));
        dp[i][j] = min;
        return min;

    }
}
