public class MovingAverage {
    private List<Integer> list;
    private int size;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.list = new ArrayList();
    }
    
    public double next(int val) {
        list.add(val);
        sum+=val;
        if(this.list.size()>this.size){
            sum -= list.get(0);
            list.remove(0);
        }
        
        return (double) sum/list.size();
    
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */