class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0, n = temperatures.length; i < n; i++) {
            
            int t = temperatures[i];
            
            while (!stack.empty() && t > stack.peek()[1]){
                result[stack.peek()[0]] = i - stack.peek()[0];
                stack.pop();
            }

            stack.push(new int[]{i, t});
        }

        result[temperatures.length - 1] = 0;
        return result;
    }
}
