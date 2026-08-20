class Solution {
    public List<Integer> partitionLabels(String s) {
        // A linear - time solution approach to this problem
        
        //Storing the entries of char & int pairs, WHERE, the int is the last index
        HashMap<Character, Integer> hashMap = new HashMap<>();
        //Returning List
        List<Integer> res = new ArrayList<>();
        
        //First linear iteration -> keeping track of the last position index of a char
        for (int i = 0, n = s.length(); i < n; i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), 0);
            }

            hashMap.put(s.charAt(i), Math.max(i, hashMap.get(s.charAt(i))));
        }

        int l = 0;
        int r = 0;

        for (int i = 0, n = s.length(); i < n; i++) {
            if (i <= r) {
                char curr = s.charAt(i);

                r = Math.max(r, hashMap.get(curr));
            } else if (i > r) {
                res.add(r - l + 1);
                l = i;
                r = hashMap.get(s.charAt(i));
            }
        }

        res.add(r - l + 1);

        return res;
    }
}
