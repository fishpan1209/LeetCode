public class MovingAverage {
    private List<Integer> list;
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.list = new ArrayList();
    }
    
    public double next(int val) {
        list.add(val);
        if(this.list.size()>this.size){
            this.list.remove(0);
        }
        
            int sum=0;
            for(int i : list){
                sum+=i;
            }
            return (double) sum/list.size();
    
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */