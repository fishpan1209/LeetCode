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
    class Result{
        private int min;
        private int max;
        private int size;
        
        public Result(int min, int max, int size){
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        Result res = findLargestBST(root);
        return Math.abs(res.size);
    }
    
    public Result findLargestBST(TreeNode root){
        if(root==null) return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Result left = findLargestBST(root.left);
        Result right = findLargestBST(root.right);
        if(left.size<0 || right.size<0 || left.max >= root.val || right.min <= root.val) return new Result(0, 0, Math.max(Math.abs(left.size), Math.abs(right.size)) * -1);
        else return new Result(Math.min(left.min, root.val), Math.max(right.max, root.val), left.size+right.size+1);
    }
}
