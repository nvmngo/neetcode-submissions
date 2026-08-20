class Solution {
    public List<String> letterCombinations(String digits) {
        //the intuition for this question:
        /*
            We will store the CHARS that can be lead from each of
            the DIGIT in a HashMap

            Algorithms:
            - Splitting the string 'digits' to a char array
            - then go through each of the digit
            -> for each situation (where a situtation is determined by the
            current letter combination and the current 'digit' that we are considering) 
            -> go through each of the possible chars that digit maps to
        */

        List<String> res = new LinkedList<>();
        HashMap<Character, Character[]> hashMap = new HashMap<>();
        //adding the entry of key & value pair
        hashMap.put('2', new Character[]{'a', 'b', 'c'});
        hashMap.put('3', new Character[]{'d', 'e', 'f'});
        hashMap.put('4', new Character[]{'g', 'h', 'i'});
        hashMap.put('5', new Character[]{'j', 'k', 'l'});
        hashMap.put('6', new Character[]{'m', 'n', 'o'});
        hashMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        hashMap.put('8', new Character[]{'t', 'u', 'v'});
        hashMap.put('9', new Character[]{'w', 'x', 'y', 'z'});

        char[] nums = digits.toCharArray();

        String current = "";
        
        helper(0, nums, current, res, hashMap);

        return res;
    }

    public void helper(int index, char[] nums, String current, List<String> res, HashMap<Character, Character[]> hashMap) {
        //base case
        if (index == nums.length) {
            
            if (current.equals("")) return;

            res.add("" + current);
            return;
        }

        //recursive case
        Character[] chars = hashMap.get(nums[index]);
        for (char c : chars) {
            current += c;
            helper(index + 1, nums, current, res, hashMap);
            current = current.substring(0, current.length() - 1);
        }
    }
}
