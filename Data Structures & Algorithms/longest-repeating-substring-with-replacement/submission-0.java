class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        int l = 0; 
        int r = 0;

        int max = 0;

        int res = 1;

        while (r < s.length()) {
            //adding key-value pair
            if (!hashMap.containsKey(s.charAt(r))) {
                hashMap.put(s.charAt(r), 0);
            }
            hashMap.put(s.charAt(r), hashMap.get(s.charAt(r)) + 1);

            //finding char with max occurance
            max = getMaxOccurence(hashMap);

            //checking for validity
            int length = r - l + 1;

            while (length - max > k) {
                hashMap.put(s.charAt(l), hashMap.get(s.charAt(l)) - 1);
                max = getMaxOccurence(hashMap);

                l++;
                length--;
            }        

            //if valid, check for length
            res = Math.max(length, res);

            r++;
        }

        return res;
    }

    public int getMaxOccurence (HashMap<Character, Integer> hashMap) {
        int max = 0;
        for (char c : hashMap.keySet()) {
            if (hashMap.get(c) > max) {
                max = hashMap.get(c);
            }
        }

        return max;
    }
}
