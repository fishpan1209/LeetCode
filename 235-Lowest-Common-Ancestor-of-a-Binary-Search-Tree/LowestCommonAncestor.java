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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        int m = Math.min(p.val, q.val);
        int n = Math.max(p.val, q.val);
        if(root.val < m){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(root.val >n ){
            return lowestCommonAncestor(root.left, p,q);
        }
        else return root;
    }
}