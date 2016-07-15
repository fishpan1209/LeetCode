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
    public List<Interval> merge(List<Interval> intervals) {
        // sort list by start
        Collections.sort(intervals, new Comparator<Interval>() {    
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }               
        });
        for(Interval i : intervals){
            System.out.println(i.start);
        }
        
        List<Interval> res = new ArrayList<Interval>();
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        
        for(int i=0; i<intervals.size()-1; i++){
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i+1);
        
            if(i1.end>=i2.start){
                e = i2.end;
            }
            else{
                res.add(new Interval(s, e));
                s = i2.start;
                e = Math.max(i1.end, i2.end);
            }
            
        }
        if(e==intervals.get(intervals.size()-1).end){
                res.add(new Interval(s, e));
            }
        return res;
    }
}