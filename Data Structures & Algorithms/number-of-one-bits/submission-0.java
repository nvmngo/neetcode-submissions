class Solution {
    public int hammingWeight(int n) {
        int res = 0;

        if ((n & 1) == 1) {
            n--;
            res++;
        }

        while (n != 0) {
            int power = (int)(Math.log(n) / Math.log(2));
            res++;
            n -= Math.pow(2, power);
        }

        return res;
    }
}
