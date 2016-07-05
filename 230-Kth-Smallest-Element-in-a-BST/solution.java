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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        int count = count(root.left);
        if(k<=count){
            return kthSmallest(root.left, k);
        }
        else if(k>count+1){
            return kthSmallest(root.right, k-count-1);
        }
        return root.val;
    }
    
    public int count(TreeNode root){
        if(root==null) return 0;
        return count(root.left)+count(root.right)+1;
    }
}