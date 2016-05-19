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
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        
        int left = 0, right=0;
        int left_left=0, right_right=0;
        
        if(root.left!=null){
            left = rob(root.left);
            if(root.left.left!=null && root.left.right!=null) left_left = rob(root.left.left)+rob(root.left.right);
            else if(root.left.left!=null) left_left = rob(root.left.left);
            else left_left = rob(root.left.right);
                
        }
        if(root.right!=null){
            right = rob(root.right);
            if(root.right.left!=null && root.right.right!=null) right_right = rob(root.right.left)+rob(root.right.right);
            else if(root.right.left!=null) right_right = rob(root.right.left);
            else right_right = rob(root.right.right);
        }
      return Math.max(root.val+left_left+right_right, left+right);
    }
}