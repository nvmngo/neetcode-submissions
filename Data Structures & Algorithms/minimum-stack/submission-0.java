class MinStack {

    private java.util.Stack<Integer> stack;
    private java.util.Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        
        if (this.minStack.empty()) minStack.push(val);
        else {
            if (val <= this.minStack.peek()) this.minStack.push(val);
            else this.minStack.push(this.minStack.peek());
        }
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
