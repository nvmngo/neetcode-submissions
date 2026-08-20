class Solution {
    public String foreignDictionary(String[] words) {

        HashMap<Character, Set<Character>> hashMap = new HashMap<>();

        // IMPORTANT:
        // Add every character, including characters with no outgoing edges
        for (String word : words) {
            for (char c : word.toCharArray()) {
                hashMap.putIfAbsent(c, new HashSet<>());
            }
        }

        int l = 0;
        int r = 1;

        // Build ordering relationships
        while (r < words.length) {

            int i = 0;
            boolean differ = false;

            while (i < words[l].length() && i < words[r].length()) {

                char left = words[l].charAt(i);
                char right = words[r].charAt(i);

                if (left != right) {

                    // left must come before right
                    hashMap.get(left).add(right);

                    differ = true;
                    break;
                }

                i++;
            }

            // Invalid prefix case:
            // ["abc", "ab"]
            if (!differ && words[l].length() > words[r].length()) {
                return "";
            }

            l++;
            r++;
        }

        List<Character> res = new ArrayList<>();

        HashSet<Character> visited = new HashSet<>();
        HashSet<Character> visiting = new HashSet<>();

        // Must DFS from EVERY node
        for (char c : hashMap.keySet()) {

            if (!visited.contains(c)) {

                if (!helper(c, hashMap, res, visited, visiting)) {
                    return "";
                }
            }
        }

        StringBuilder string = new StringBuilder();

        for (char c : res) {
            string.append(c);
        }

        return string.toString();
    }


    public boolean helper(
        char curr,
        HashMap<Character, Set<Character>> hashMap,
        List<Character> res,
        HashSet<Character> visited,
        HashSet<Character> visiting
    ) {

        // Already completely processed
        if (visited.contains(curr)) {
            return true;
        }

        // We're currently processing this node
        // -> coming back to it means cycle
        if (visiting.contains(curr)) {
            return false;
        }

        visiting.add(curr);

        for (char next : hashMap.get(curr)) {

            if (!helper(next, hashMap, res, visited, visiting)) {
                return false;
            }
        }

        // curr is now completely resolved
        visiting.remove(curr);
        visited.add(curr);

        // prepend because DFS gives reverse topological order
        res.add(0, curr);

        return true;
    }
}