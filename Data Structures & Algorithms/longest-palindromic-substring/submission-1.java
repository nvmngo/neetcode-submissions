class Solution {
    public String longestPalindrome(String s) {
        
        String res = String.valueOf(s.charAt(0));
        int length = 1;

        for (int i = 0, n = s.length(); i < n; i++) {
            
            //odd-length case
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > length) {
                    res = s.substring(l, r + 1);
                    length = r - l + 1;
                }
                l--;
                r++;
            }

            //even-length case
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > length) {
                    res = s.substring(l, r + 1);
                    length = r - l + 1;
                }
                l--; 
                r++;
            }
        }

        return res;
    }
}
