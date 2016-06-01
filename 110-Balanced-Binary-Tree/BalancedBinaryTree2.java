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
    public boolean isBalanced(TreeNode root) {
        // bottom up solution, O(n);
        // if height diff > 1, break immediately
        if(root==null) return true;
        return height(root)!=-1;
    }
    
    public int height(TreeNode root){
        if(root==null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(l==-1) return -1;
        if(r==-1) return -1;
        if(Math.abs(l-r)>1) return -1;
        else return Math.max(l, r)+1;
    }
}