class Solution {
    public int coinChange(int[] coins, int amount) {
        //The intuition for this question
        /* 
        The first naive approach way that one might come up:
        -> Taking the largest value coin
            -> Keep deducting the ammount, until the amount < coin 
            -> Then continue with the smaller coin
        
        Though this approach, though has a premise of resulting the minimum value
        in such 'valid case', can be wrong if the smallest coin is not '1'
            BY saying that, I mean the smallest coin might be > the lowest the amount can be

        But by looking at this with this way of thinking -> it does give us some kind of idea

        if (coin[0] == '1') --> Just follow the tradition way of thinking
        else -> We need to use this algorithm:

        - We will iterate all the possible of number of largest coin that we can hand in
            - THEN, find the minimum number of coinChange, can be done with the remainder
            WITH, the largest coin being the next largest coin we're having in the array
        - Compare all those result -> fimd the minimum
        */

        // Arrays.sort(coins);

        if (coins[0] == 1) {
            return easyCase(coins, amount);
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        return coinChangeHelper(coins.length - 1, coins, amount, hashMap);
    }

    public int coinChangeHelper(int index, int[] coins, int amount, HashMap<Integer, Integer> hashMap) {
        
        //base case
        if (amount == 0) {
            return 0;
        }

        if (hashMap.containsKey(amount)) {
            return hashMap.get(amount);
        }

        //base case
        if (index == 0) {

            int count = 0;

            while (amount > 0) {
                amount-=coins[0];
                count++;
            }

            if (amount == 0) {
                if (!hashMap.containsKey(amount)) {
                    hashMap.put(amount, count);
                } else {
                    hashMap.put(amount, Math.min(hashMap.get(amount), count));
                }
                return count;
            }

            else return -1;
        }

        //recursive case
        int n = amount / coins[index];
        int min = Integer.MAX_VALUE;
        for (int i = n; i >= 0; i--) {
            int change = i + coinChangeHelper(index - 1, coins, amount - coins[index]*i, hashMap);
            if (change != i - 1) {
                min = Math.min(min, change);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        if (!hashMap.containsKey(amount)) {
            hashMap.put(amount, min);
        } else {
            hashMap.put(amount, Math.min(min, hashMap.get(amount)));
        }

        return min;
    }



    public int easyCase(int[] coins, int amount) {
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            while (amount - coin > 0) {
                amount-=coin;
                count++;
            }

            if (amount - coin == 0) {
                count++;
                return count;
            }
        }

        return count;
    }
}
