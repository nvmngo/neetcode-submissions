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
    public boolean canAttendMeetings(List<Interval> intervals) {
        //sorting the intervals
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        //iterating through the intervals, checking for overlapping
        for (int i = 0, n = intervals.size(); i < n - 1; i++) {
            //if overlapping
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }

        //if none overlap -> return true
        return true;
    }
}
