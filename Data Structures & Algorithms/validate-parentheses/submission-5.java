class Solution {
    public boolean isValid (String s) {
        java.util.HashMap<Character, Character> hashMap = new HashMap<>();
        java.util.Stack<Character> stack = new Stack<>();

        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(c) && stack.isEmpty()) {
                return false;
            }
            else if (hashMap.containsKey(c) && stack.peek() == hashMap.get(c)) { 
                stack.pop();
                continue;
            } else if (hashMap.containsKey(c) && stack.peek() != hashMap.get(c)) {
                return false;
            }

            stack.push(c);
        }

        return stack.empty();
    }
}