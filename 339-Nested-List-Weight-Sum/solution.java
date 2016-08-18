/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        return depthSum(nestedList,0, 1);
    }
    
    public int depthSum(List<NestedInteger> nestedList, int res, int level){
        
        for(NestedInteger n : nestedList){
            if(n.isInteger()) {
                res += n.getInteger()*level;
                System.out.println(" added int : "+n.getInteger()+" level: "+level);
            }
            else{
                List<NestedInteger> cur = n.getList();
                // for each list, start with a new sum=0
                res += depthSum(cur, 0, level+1);
            }
        }
        return res;
    }
}