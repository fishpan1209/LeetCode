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
    public int countNodes(TreeNode root) {
        int h = height(root);
        if(h<=1) return h;
        int right = height(root.right);
        if((h-1 )== right){
            return (1<<(h-1))+countNodes(root.right);
        }
        else return (1<<(h-2))+countNodes(root.left);
        
    }
    
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+height(root.left);
    }
}