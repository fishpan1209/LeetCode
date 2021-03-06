public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        if(nums==null || nums.length==0) return;
        sum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            sum[i+1] = sum[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        // include i and j
        // sum[j+1] sum of all numbers before(and include) j;
        // sum[i] sum of all numbers before(and include) i-1
        return sum[j+1]-sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);