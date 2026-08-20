class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) { return ""; }

        HashMap<Character, Integer> hash1 = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!hash1.containsKey(c)) {
                hash1.put(c, 1);
            } else {
                hash1.put(c, hash1.get(c) + 1);
            }
        }

        HashMap<Character, Integer> hash2 = new HashMap<>();

        int l = 0; 
        double min = Double.POSITIVE_INFINITY;
        String res = "";

        for (int r = 0, n = s.length(); r < n; r++) {
            if (!hash2.containsKey(s.charAt(r))) {
                hash2.put(s.charAt(r), 1);
            } else {
                hash2.put(s.charAt(r), hash2.get(s.charAt(r)) + 1);
            }

            while (isValid(hash1, hash2)) {
                if (r - l + 1 < min) {
                    res = "";
                    min = r - l + 1;
                    for (int i = l; i <= r; i++) {
                        res+= s.charAt(i);
                    }
                }
                hash2.put(s.charAt(l), hash2.get(s.charAt(l)) - 1);
                l++;
            }
        }
        return res;
    }

    private boolean isValid (HashMap<Character, Integer> hash1, HashMap<Character, Integer> hash2) {
        for (char c : hash1.keySet()) {
            if (hash2.get(c) == null) { return false; }
            if (hash2.get(c) < hash1.get(c)) {
                return false;
            }
        }

        return true;
    }
}
