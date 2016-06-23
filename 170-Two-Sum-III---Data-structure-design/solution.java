import java.util.HashSet;
public class TwoSum {
    private ArrayList<Integer> nums;
    public TwoSum(){
        this.nums = new ArrayList();
    }

    // Add the number to an internal data structure.
	public void add(int number) {
	    this.nums.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    if(this.nums.size()<2) return false;
	    HashSet<Integer> set = new HashSet();
	    for(int i=0; i<this.nums.size(); i++){
	        int n1 = this.nums.get(i);
	        int n2 = value-n1;
	        if(set.contains(n2)) return true;
	        else set.add(n1);
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);