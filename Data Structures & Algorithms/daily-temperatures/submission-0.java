class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];
        
        for (int i = 0, n = temperatures.length; i < n - 1; i++) {
            int min = temperatures[i];
            Stack<Integer> stack = new Stack<>();
            
            for (int j = i + 1; j < n; j++) {
                stack.push(temperatures[j]);
                if (temperatures[j] > min) {
                    result[i] = stack.size();
                    break;
                }
                if (j == n - 1) result[i] = 0;
            }
        }

        result[temperatures.length - 1] = 0;
        return result;
    }
}
