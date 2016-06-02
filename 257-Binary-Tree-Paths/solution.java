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
        dfs(root, res, "");
        return res;
    }
    
    public void dfs(TreeNode root, List<String> res, String path){
        if(root.left==null && root.right==null) res.add(path+root.val);
        if(root.left!=null) dfs(root.left, res, path+root.val+"->");
        if(root.right!=null) dfs(root.right, res, path+root.val+"->");
    }
}