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

        int remainder = 0;
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int sum = (a & 1) ^ (b & 1);
            int bit = sum;

            // adding if there's remainder
            if (remainder > 0) {
                if (sum == 0) {
                    bit = 1;
                } else {
                    bit = 0;
                    remainder++;
                }

                remainder--;
            }

            res = res | (bit = bit << i);

            // adding remainder
            if (sum == 0 && (a & 1) == 1) {
                remainder++;
            }

            // continue the way
            a = a >> 1;
            b = b >> 1;
        }

        return res;
    }
}
