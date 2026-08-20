class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) { return false; }
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : hand) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 0);
            }

            hashMap.put(num, hashMap.get(num) + 1);

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i <= max; i++) {
            if (hashMap.containsKey(i)) {
                while (hashMap.get(i) > 0) {
                    hashMap.put(i, hashMap.get(i) - 1);

                    for (int j = i + 1; j < i + groupSize; j++) {
                        if (!hashMap.containsKey(j)) {
                            return false;
                        }

                        int freq = hashMap.get(j) - 1;
                        hashMap.put(j, hashMap.get(j) - 1);

                        if (freq == 0) {
                            hashMap.remove(j);
                        }
                    }
                }
            }
        }

        return true;
    }  
}



//------------------------------------------------------------------------------------

class Heap {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //handling edge case
        if (hand.length % groupSize != 0) {
            return false;
        }

        //creating a MIN-HEAP, keeping track of the smallest element
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //adding element into the heap
        for (int num : hand) {
            heap.offer(num);
        }

        //creating a list, storing the entries of each group
        //WHERE each group is structured by a STACK, peeking the last added int
        List<Stack<Integer>> groups = new ArrayList<>();
        int capacity = hand.length / groupSize;

        //polling out heap minimum card, and distributing to the groups
        while (!heap.isEmpty()) {
            //poll out the min card
            int card = heap.poll();

            //if there's none group
            if (groups.size() == 0) {
                //creating the first group
                Stack<Integer> first = new Stack<>();
                first.push(card);
                groups.add(first);
                continue;
            }

            //allocating the card into the groups
            boolean hasAdded = false;
            for (Stack<Integer> group : groups) {
                if (group.peek() + 1 == card && group.size() < groupSize) {
                    group.push(card);
                    hasAdded = true;
                    break;
                }
            }

            if (hasAdded == false) {
                //if all groups have been added
                if (groups.size() >= capacity) { return false; }

                //creating new group for the new card
                Stack<Integer> group = new Stack<>();
                group.push(card);
                groups.add(group);
            }
        }

        return true;
    }
}