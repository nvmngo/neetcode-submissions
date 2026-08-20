class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        //sort the positions and the speeds
        for (int i = position.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (position[j] > position[j+1]) {
                    int temp = position[j];
                    position[j] = position[j + 1];
                    position[j + 1] = temp;

                    temp = speed[j];
                    speed[j] = speed[j+1];
                    speed[j+1] = temp;
                }
            }
        }

        double[] time = new double[position.length];
        for (int i = 0, n = position.length; i < n; i++) {
            time[i] = (double)(target - position[i]) / speed[i];
        }

        Stack<Double> stack = new Stack<>();
        for (double t : time) {
            while (!stack.empty() && t >= stack.peek()) {
                stack.pop();
            }

            stack.push(t);
        }

        return stack.size();
    }
}
