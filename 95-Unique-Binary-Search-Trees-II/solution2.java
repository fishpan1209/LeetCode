/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
       
        if(n<1) return new ArrayList<TreeNode>();
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList();
        if(start>end) {
            res.add(null);
            return res;
        }
        if(start==end){
            res.add(new TreeNode(start));
            return res;
        }
        for(int i=start; i<=end; i++){
            
            List<TreeNode> left = generate(start, i-1);
            List<TreeNode> right = generate(i+1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}