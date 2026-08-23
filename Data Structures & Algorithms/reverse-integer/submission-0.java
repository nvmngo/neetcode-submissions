class Solution {
    public int reverse(int x) {
        
        int res = 0;

        while (x / 10 != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
            return 0;
        }

        else if (res == Integer.MAX_VALUE / 10) {
            if (x > 7) {
                return 0;
            }
        }

        else if (res == Integer.MIN_VALUE / 10) {
            if (x < -8) {
                return 0;
            }
        }

        return res * 10 + x;

    }
}
