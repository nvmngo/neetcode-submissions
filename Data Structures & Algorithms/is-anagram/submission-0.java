class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> hashMapS = new HashMap<>();
        HashMap<Character, Integer> hashMapT = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            if (!hashMapS.containsKey(c)) {
                hashMapS.put(c, 0);
            } else {
                hashMapS.put(c, hashMapS.get(c) + 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!hashMapT.containsKey(c)) {
                hashMapT.put(c, 0);
            } else {
                hashMapT.put(c, hashMapT.get(c) + 1);
            }
        }

        return hashMapS.equals(hashMapT);
    }
}
