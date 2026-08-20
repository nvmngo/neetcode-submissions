class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<HashMap, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            HashMap<Character, Integer> charMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (!charMap.containsKey(c)) {
                    charMap.put(c, 0);
                } else {
                    charMap.put(c, charMap.get(c) + 1);
                }
            }

            if (!hashMap.containsKey(charMap)) {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                hashMap.put(charMap, stringList);
            } else {
                List<String> stringList = hashMap.get(charMap);
                stringList.add(s);
                hashMap.put(charMap, stringList);
            }
        }

        List<List<String>> listList = new ArrayList<>();
        
        for (HashMap hash : hashMap.keySet()) {
            listList.add(hashMap.get(hash));
        }

        return listList;
    }
}
