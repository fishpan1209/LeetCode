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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root==null) return res;
        rightSideView(root, res, 0);
        return res;
    }
    
    public void rightSideView(TreeNode root, List<Integer> res, int h){
        // must decide if root=null
        if(root==null) return;
        if(h==res.size()){
            res.add(root.val);
        }
        // right first, then left
        rightSideView(root.right, res, h+1);
        rightSideView(root.left, res, h+1);
        
    }
}