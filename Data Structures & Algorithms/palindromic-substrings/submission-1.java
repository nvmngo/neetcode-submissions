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
        
        int n = s.length();
        int count = 0;

        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
