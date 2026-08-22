class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int pow = (int) (Math.log(i) / Math.log(2));
            
            if (pow < 2) {
                if (i == 0) {
                    res[i] = 0;
                } else if (i == 1 || i == 2) {
                    res[i] = 1;
                } else {
                    res[i] = 2;
                }
            }

            else {
                res[i] = res[i - (int)Math.pow(2, pow)] + 1;
            }
        }

        return res;
    }
}
