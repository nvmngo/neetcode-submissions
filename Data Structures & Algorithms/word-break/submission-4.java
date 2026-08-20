class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //The intuition for this question:
        /* 
        Use a DPS approach:

        - Iterate through each of the character index of the string 's'
        - IF the substring starting from index '0' to index 'i' is in the wordDict
            -> Get the remain substring
            -> Use recursion to check WHETHER that remainder is VALID
                IF (valid) -> RETURN TRUE
                Otherwise -> Keep iterating
        - If finish FOR loop
            - RETURN FALSE
        */

        Set<String> words = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        return wordBreakHelper(s, 0, words, memo);
    }

    public boolean wordBreakHelper(String s, int i, Set<String> words, Boolean[] memo) {
        //base case
        if (i == s.length()) { return true; }
        if (memo[i] != null) { return memo[i]; }        

        //recursive case
        for (int j = i, n = s.length(); j < n; j++) {
            
            String substring = s.substring(i, j + 1);

            if (words.contains(substring)) {
                if (wordBreakHelper(s, j + 1, words, memo) == true) {
                    memo[i] = true;
                    return true;
                }
            }
        }

        memo[i] = false;
        return false;
    }
}
