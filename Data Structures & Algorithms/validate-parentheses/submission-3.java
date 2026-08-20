

class Solution {
    public boolean isValid(String s) {

        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
            return false;
        else if (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == '[' || s.charAt(s.length() - 1) =='{')
            return false;
        else {
            java.util.HashMap<Character, Character> hashMap = new HashMap<>();
            hashMap.put(')', '(');
            hashMap.put(']', '[');
            hashMap.put('}', '{');
            java.util.Stack<Character> stack = new Stack<>();

            for (int i = 0, n = s.length(); i < n; i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    try {
                        char pop = stack.pop();
                        if (pop != hashMap.get(c)) return false;
                    } catch (java.util.EmptyStackException e) {
                        return false;
                    }
                }
            }

            return stack.empty();

        }
    }
}
