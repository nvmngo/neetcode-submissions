class Solution {
    public double myPow(double x, int n) {
        // The intuition for this question:
        /* 
            Normally, the intuitive solution that we normally come up with - using recursion, bottom up recursion
            Though, for large value of n -> the solution can be ineffiecient

            A more clever way -> Split the problem into halves:
                    x^n = x^(n/2) * x^(n/2)

            This will be a sort of 'binary search approach'
            WHERE the time complexity now is O(log(n))
        */

        // base case
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / (x * myPow(x, -(n + 1)));
        }

        if (x == 1 || x == 0) {
            return x;
        }

        if (x == -1) {
            return (n % 2 == 0) ? 1 : -1;
        }

        // recursive case
        double half = myPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return half * half * x;
    }
}
