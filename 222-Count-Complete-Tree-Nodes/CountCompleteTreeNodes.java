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
        if(h==0) return 0;
        // if right tree height = left tree height, left nodes(2^(h-1))+right nodes
        // else 
        return height(root.right)==h-1? (1<<h-1)+countNodes(root.right):(1<<h-2)+countNodes(root.left);
    }
    
    public int height(TreeNode root){
        // left tree is always full, only have to count left height
        return root==null ? 0: 1+height(root.left);
    }
}