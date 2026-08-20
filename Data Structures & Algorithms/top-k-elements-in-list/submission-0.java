class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

        LinkedList<Integer> distinctNum = new LinkedList<>();
        for (int i : hashMap.keySet()) {
            distinctNum.add(i);
        }

        for (int i = distinctNum.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (hashMap.get(distinctNum.get(j)) < hashMap.get(distinctNum.get(j+1))) {
                    int temp = distinctNum.get(j);
                    distinctNum.set(j, distinctNum.get(j+1));
                    distinctNum.set(j+1, temp);
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = distinctNum.get(i);
        }

        return result;
    }
}
