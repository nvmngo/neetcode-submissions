class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0, n = piles.length; i < n; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int answer = 0;

        while (left <= right) {

            int index = (right + left) / 2;
            if (timeTaken(piles, index) > h) {
                left = index + 1;
            } else {
                answer = index;
                right = index - 1;
            }
        }

        return answer;
    }

    public int timeTaken(int[] piles, int k) {
        int res = 0;
        for (int i = 0, n = piles.length; i < n; i++) {
            res += (piles[i] % k == 0 ? piles[i] / k : piles[i] / k + 1);
        }
        return res;
    }
}
