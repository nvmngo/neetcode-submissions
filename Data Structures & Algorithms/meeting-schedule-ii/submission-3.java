/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        
        if (intervals.size() == 0) return 0;
        
        //sorting the intervals, based on their starting timex
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        //HashMap - data structure storing the entries of KEY & VALUES -> Key:  Room lastest ending time || Value:  The number of rooms with that ending time
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // left & right pointers for CURR and NEXT intervals
        int l = 0;
        int r = 1;

        while (r < intervals.size()) {
            Interval curr = intervals.get(l);
            Interval next = intervals.get(r);

            //if overlapping
            if (curr.end > next.start) {
                Interval removed = next;
                if (curr.start == next.start) {
                    if (curr.end > next.end) {
                        removed = curr;
                        l = r;
                    }
                } 
                r++;

                //adding the removed interval into one of the room
                int max = Integer.MIN_VALUE;
                for (int end : hashMap.keySet()) {
                    if (removed.start >= end) {
                        max = Math.max(max, end);
                    }
                }

                //if a room is matched
                if (max != Integer.MIN_VALUE) {
                    int freq = hashMap.get(max);
                    if (freq == 1) {
                        hashMap.remove(max);
                    } else {
                        hashMap.put(max, hashMap.get(max) - 1);
                    }
                }

                if (!hashMap.containsKey(removed.end)) {
                    hashMap.put(removed.end, 1);
                } else {
                    hashMap.put(removed.end, hashMap.get(removed.end) + 1);
                }
            }

            //if not
            else {
                l = r;
                r++;
            }
        }

        int count = 1;
        for (int key : hashMap.keySet()) {
            count += hashMap.get(key);
        }

        return count;
    }
}
