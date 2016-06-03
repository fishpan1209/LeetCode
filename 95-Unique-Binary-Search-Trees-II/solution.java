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
        List<TreeNode> res = new ArrayList();
        if(n<1) return res;
        else return generate(1, n);
    }
    
    public List<TreeNode> generate(int start, int end){
       List<TreeNode> res = new ArrayList();
       // if i=start or i=end: start>i-1, i+1>end
       if(start>end){
           res.add(null);
           return res;
       }
       if(start==end){
           res.add(new TreeNode(start));
           return res;
       }
       else {
           for(int i=start; i<=end; i++){
               List<TreeNode> left = generate(start, i-1);
               List<TreeNode> right = generate(i+1, end);
               for(TreeNode l : left){
                   for(TreeNode r : right){
                       TreeNode root = new TreeNode(i);
                       root.left = l;
                       root.right = r;
                       res.add(root);
                   }
               }
           }
       }
    return res;   
    }
}