class Solution {
    public int longestConsecutive(int[] nums) {
        // The intuition for this question:
        /* 
            HashMap storing the entry of STARTING - ENDING pair
            Linearly extend the INTERVAL
        */

        int res = 0;
        HashMap<Integer, Integer> main = new HashMap<>();   // storing START - END
        HashMap<Integer, Integer> side = new HashMap<>();   // storing END - START
        HashSet<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num)) { continue; }    // skip visited num

            int length = 1;
            boolean isAdded = false;

            // extend lower end
            if (main.containsKey(num + 1)) {
                int upper = main.get(num + 1);
                main.remove(num + 1);
                main.put(num, upper);
                side.put(upper, num);

                isAdded = true;

                length = upper - num + 1;
            }

            // extend upper end
            if (side.containsKey(num - 1)) {
                int lower = side.get(num - 1);
                side.remove(num - 1);
                side.put(num, lower);
                main.put(lower, num);

                isAdded = true;

                length = Math.max(length, num - lower + 1);
            }

            if (main.containsKey(num) && side.containsKey(num)) {
                int lower = side.get(num);
                int upper = main.get(num);

                main.put(lower, upper);
                side.put(upper, lower);

                length = Math.max(length, upper - lower + 1);
            }

            if (!isAdded) {
                main.put(num, num);
                side.put(num, num);
            }

            res = Math.max(length, res);
            visited.add(num);
        }

        return res;
    }
}
