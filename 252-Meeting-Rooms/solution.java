/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
    for (int i = 0; i < intervals.length; i++) {
        for (int j = i + 1; j < intervals.length; j++) {
            if (overlap(intervals[i], intervals[j])) return false;
        }
    }
    return true;
}

private boolean overlap(Interval i1, Interval i2) {
    return ((i1.start >= i2.start && i1.start < i2.end)
         || (i2.start >= i1.start && i2.start < i1.end));
}
}