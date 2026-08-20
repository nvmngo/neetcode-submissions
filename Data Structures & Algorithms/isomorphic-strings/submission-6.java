class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0, n = s.length(); i < n; i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                if (set.contains(t.charAt(i))) return false;
                hashMap.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }

            if (hashMap.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}