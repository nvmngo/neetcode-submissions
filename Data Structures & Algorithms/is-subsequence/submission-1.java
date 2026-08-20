class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) { return false; }
        if (s.length() == 0) { return true; }

        int pointer = 0;

        for (int i = 0, n = t.length(); i < n; i++) {
            
            if (pointer == s.length()) { return true; }
            
            if (s.charAt(pointer) == t.charAt(i)) {
                pointer++;
            }
        }

        if (pointer >= s.length()) return true;
        return false;
    }
}