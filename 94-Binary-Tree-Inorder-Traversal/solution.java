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
        List<Integer> res = new ArrayList();
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