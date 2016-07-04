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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if(root==null) return res;
        path(root, res, "");
        return res;
    }
    
    public void path(TreeNode root, List<String> res, String p){
        if(root==null) return;
        if(root.left==null && root.right==null){
            p += root.val;
            res.add(p);
            return;
        }
        p += root.val+"->";
        if(root.left!=null) path(root.left, res, p);
        if(root.right!=null) path(root.right, res, p);
    }
}