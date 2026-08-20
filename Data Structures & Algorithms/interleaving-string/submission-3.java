class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //The intuition for this question:
        /* 
        Start checking with the third string:
        - Whether the very initial of the string is part of the 'first' or 'second'
        string

        - Extract the substring out of the 'third' and the owner of that substring
            - What remains in the 'third' string -> a new string that should now be
            started by the substring of the counter string (if 1 -> 2 | 2 -> 1)
                - If it's not the case -> return false 
                                    SINCE the starting substring of the new 's3'
                                    is not part of either 's1' or 's2'
                - If it does, recursively evaluate the same thing with
                the new s1, s2, and s3
                    -> Return the output of the recursive method
        
        - From the first iteration, the very first substring that we extracted out
        might have the 'starting position' of the other string
            -> if the extraction of the whole substring RETURN FALSE
            -> check with the other starting position of substring

        - We can optimize this by implementing a 'cache':
            dp[i][j] = whether, the new two substring, starting from i for
            's1' - starting from j for 's2', can interleave to the new substring
            of 's3' starting at 'i + j'
        */

        if (s3.length() < s1.length() + s2.length()) { return false; }

        Boolean[][] dp = new Boolean[s1.length()][s2.length()];
        return helper(0, 0, s1, s2, s3, dp);
    }

    public boolean helper(int one, int two, String s1, String s2, String s3,
                          Boolean[][] dp) {
        
        //base case
        if (one == s1.length()) {
            return s3.substring(one + two, s3.length()).equals(s2.substring(two, s2.length()));
        }

        if (two == s2.length()) {
            return s3.substring(one + two, s3.length()).equals(s1.substring(one, s1.length()));
        }

        if (dp[one][two] != null) {
            return dp[one][two];
        }

        //recursive case

        boolean res = false;
        if (s3.charAt(one + two) == s1.charAt(one)) {
            boolean atOne = helper(one + 1, two, s1, s2, s3, dp);
            if (atOne) res = true;
        }

        if (s3.charAt(one + two) == s2.charAt(two)) {
            boolean atTwo = helper(one, two + 1, s1, s2, s3, dp);
            if (atTwo) res = true;
        }

        dp[one][two] = false;
        return res;
    }
}
