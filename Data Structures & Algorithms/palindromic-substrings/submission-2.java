class Solution {
    public int countSubstrings(String s) {
        //The intuition for this question:
        /*
        Iterate through all of the 'substring', checking whether
            THAT substring is a 'PALINDROME' or NOT

        We can store the result in a 2x2 matrix
        WHERE  
                matrix[i][j] = 'the result of whether substring(i , j) (INCLUSIVE)
                                is a palindrome'
        */
        
        int count = 0;

        for (int i = 0, n = s.length(); i < n; i++) {
            //odd-length case
            int l = i;
            int r = i;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }

            //even-length case
            l = i;
            r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}
