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
        if(root==null || p==null || q==null) return null;
        int m = Math.min(p.val, q.val);
        int n = Math.max(p.val, q.val);
        if(m>root.val) return lowestCommonAncestor(root.right, p, q);
        else if(n<root.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}