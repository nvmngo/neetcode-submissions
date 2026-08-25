class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        int sum = 0;

        while (true) {

            if (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;

                continue;
            }   

            if (sum == 1) {
                break;
            }

            if (visited.contains(sum)) { return false; }

            n = sum;
            visited.add(sum);
            sum = 0;
        }

        return true;
    }
}
