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
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder: root-left-right
        List<Integer> res = new ArrayList();
        if(root==null) return res;
        preorder(root, res);
        return res;
        
    }
    
    public void preorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}