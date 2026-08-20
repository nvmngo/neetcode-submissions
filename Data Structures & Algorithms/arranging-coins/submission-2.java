class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        int stairs = 1;

        while (true) {
            if (n >= stairs) { 
                count++; 
                n -= stairs;
                stairs++;
            }
            else { break; }
        }

        return count;
    }
}