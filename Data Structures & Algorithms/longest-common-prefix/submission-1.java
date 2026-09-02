class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;

        while (true) {
            
            if (i >= strs[0].length()) { break; }

            char c = strs[0].charAt(i);
            boolean isBreak = false;

            for (String s : strs) { 
                if (s.length() <= i || s.charAt(i) != c) {
                    isBreak = true;
                    break;
                }
            }

            if (isBreak) { break; }

            i++;
        }

        return strs[0].substring(0, i);
    }
}