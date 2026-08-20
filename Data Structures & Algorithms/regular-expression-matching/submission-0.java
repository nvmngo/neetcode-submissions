class Solution {
    public boolean isMatch(String s, String p) {
        // The intuition for this question:
        /* 
        Implementing a cache that will store the 'boolean status' of whether:
        - The subsequence from index 'i'th of string s
        - matches, the subsequence from index 'j'th of string p

        Intuitively, compare each pair of character of the two string at once
        - IF, there're 2 normal chars -> RETURN char1 == char2
        - ELSE IF, there're a char, and a '.'
            -> Increment both of the pointers in both strings, and evaluate
        - ELSE IF, there're a char, and a '*'
            - Check the preceding char: 
                - IF, the char1 == char2:
                    -> Increment the 'i' pointer, and evaluate
                    -> IF, the following subsequences return FALSE
                        -> Backtrack 'i' -> Increment 'j' pointer
                - ELSE:
                    -> Increment the 'j' pointer, and evaluate
        */

        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return helper(0, 0, s, p, dp);
    }

    //Implement a helper method:    Determining whether [i:] == [j:]
    public boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
        //base case 
            //TODO: Implement more base cases
        if (i == s.length()) {
            while (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                j += 2;
            }

            return j >= p.length();
        }

        if (j == p.length()) {
            return i >= s.length();
        }
        
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        //recursive case
        boolean res = false;
        boolean match = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        //CASE 1: There is a '*' follow the current char
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            //Choice 1: Skip a*
            if (helper(i, j + 2, s, p, dp) == true) {
                res = true;
            }

            //Choice 2: Take one a *
            if (match && helper(i + 1, j, s, p, dp) == true) {
                res = true;
            }
        }

        //CASE 2: There is no '*' follow the current char
        else if (match) {
            res = helper(i + 1, j + 1, s, p, dp);
        }

        dp[i][j] = res;
        return res;
    }
}
