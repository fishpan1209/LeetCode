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
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder: left-root-right
        List<Integer> res = new ArrayList();
        if(root==null) return res;
        inorder(root, res);
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}