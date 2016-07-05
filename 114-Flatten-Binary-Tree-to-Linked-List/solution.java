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
    /*
    // bottom up recursion
    private TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
       
    }
    */
    
    // iterative method
    public void flatten(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        while(root!=null){
            if(root.left==null){
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while(left.right!=null) left = left.right; // to the most right child of the left subtree
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right; 
        }
    }   
}