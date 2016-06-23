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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }
    
    public int maxSum(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0,maxSum(root.left));
        int right = Math.max(0,maxSum(root.right));
        // max sum of current node
        max = Math.max(max, left+right+root.val);
        return Math.max(left, right)+root.val;
        
    }

}