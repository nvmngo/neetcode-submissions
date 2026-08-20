class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> hash1 = new HashMap<>();   
        for (char c : s1.toCharArray()) {
            if (!hash1.containsKey(c)) {
                hash1.put(c, 1);
            } else {
                hash1.put(c, hash1.get(c) + 1);
            }
        }

        HashMap<Character, Integer> hash2 = new HashMap<>();
        int l = 0;
        int r = l + s1.length() - 1;

        for (int i = l; i <= r; i++) {
            if (!hash2.containsKey(s2.charAt(i))) {
                hash2.put(s2.charAt(i), 1);
            } else {
                hash2.put(s2.charAt(i), hash2.get(s2.charAt(i)) + 1);
            }
        }

        while (r < s2.length()) {
            if (hash2.equals(hash1)) {
                return true;
            }

            if (r == s2.length() - 1) {
                break;
            }

            if (hash2.get(s2.charAt(l)) == 1) {
                hash2.remove(s2.charAt(l));
            } else {
                hash2.put(s2.charAt(l), hash2.get(s2.charAt(l)) - 1);
            }

            if (!hash2.containsKey(s2.charAt(r+1))) {
                hash2.put(s2.charAt(r+1), 0);
            }
            hash2.put(s2.charAt(r + 1), hash2.get(s2.charAt(r + 1)) + 1);

            l++;
            r++;
        }

        return false;


    }
}
