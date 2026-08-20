class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> parens = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0, n = s.length(); i < n; i++) {

            char c = s.charAt(i);

            if (c == '*') {
                stars.push(i);
            }

            else if (c == '(') {
                parens.push(i);
            }

            else if (c == ')') {
                if (parens.empty() && stars.empty()) {
                    return false;
                }

                else if (parens.empty()) {
                    stars.pop();
                }

                else {
                    parens.pop();
                }
            }
        }

        while (!parens.empty()) {
            
            if (stars.empty()) {
                return false;
            }

            if (stars.peek() > parens.peek()) {
                stars.pop();
                parens.pop();
            }

            else {
                return false;
            }
        }

        return true;
    }
}
