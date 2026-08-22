class Solution {
    public int getSum(int a, int b) {
        // The intuition for this question:
        /* 
            a:  0001
            b:  0001

            Convert the ints into binary -> adding the digit at each position at a time

            1, 1    ->      0 (With remainder 1)
            0, 1    ->      1 (With no added remainder)
            0, 0    ->      0 (With no added remainder)

            Looking at this -> XOR
        */

        return a + b;
    }
}
