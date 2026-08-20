class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        int output;

        for (String c : tokens) {
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")) {
                stack.push(Integer.parseInt(c));
            } else {
                if (c.equals("+")) {
                    int n = stack.pop() + stack.pop();
                    stack.push(n);
                } else if (c.equals("-")) {
                    int n = -stack.pop() + stack.pop();
                    stack.push(n);
                } else if (c.equals("*")) {
                    int n = stack.pop() * stack.pop();
                    stack.push(n);
                } else if (c.equals("/")) {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(n2/n1);
                }
            }
        }

        if (stack.size() == 1) { return stack.pop(); }
        else return 0;
    }
}
