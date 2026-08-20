class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0)); 

        int l = 0;
        int r = 1;

        int max = 1;

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                
                int length = r - l + 1;
                if (length > max) {
                    max = length;
                }

                r++;
            } else {
                set.clear();
                l++;
                r = l + 1;
                set.add(s.charAt(l));
            }
        }

        return max;
    }
}
