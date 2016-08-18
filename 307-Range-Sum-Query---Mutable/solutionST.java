public class NumArray {
    private int[] segmentTree;
    private int n;
    private int[] nums;

    public NumArray(int[] nums) {
        if(nums==null || nums.length==0) return;
        int n = nums.length;
        this.n = n;
        this.nums = nums;
        // calculate length of segmentTree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int len = 2 * (int) Math.pow(2, x) - 1;
        segmentTree = new int[len];
        build(nums, 0, n-1, 0);
    }

    void update(int i, int val) {
        if(i<0 || i>=n) return;
        int diff = val-nums[i];
        nums[i] = val;
        update(0, n-1, i, diff, 0);
    }

    public int sumRange(int i, int j) {
        if(i<0 || j>=n || i>j) return -1;
        return getSumRange(i, j, 0, n-1, 0);
    }
    
    private void build(int[] nums, int start, int end, int pos){
        if(start==end){
            segmentTree[pos] = nums[start];
            return;
        }
        int mid = start+(end-start)/2;
        build(nums, start, mid, 2*pos+1);
        build(nums, mid+1, end, 2*pos+2);
        segmentTree[pos] = segmentTree[2*pos+1]+segmentTree[2*pos+2];
    }
    
    private int getSumRange(int qs, int qe, int start, int end, int pos){
        if(qs<=start && qe>=end) return segmentTree[pos];
        else if(qs> end || qe<start) return 0;
        else{
            int mid = start+(end-start)/2;
            return getSumRange(qs, qe, start, mid, 2*pos+1)+getSumRange(qs, qe, mid+1, end, 2*pos+2);
        }
    }
    
    private void update(int start, int end, int i, int diff, int pos){
        if(i<start || i>end) return;
        segmentTree[pos] = segmentTree[pos]+diff;
        if(start!=end){
            int mid = start+(end-start)/2;
            update(start, mid, i, diff, 2*pos+1);
            update(mid+1, end, i, diff, 2*pos+2);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);