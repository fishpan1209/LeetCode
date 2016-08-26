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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        level(root, res, 0);
        return res;
    }
    
    public void level(TreeNode root, List<List<Integer>> res, int level){
        if(root==null) return;
        if(level >= res.size()) {
            res.add(new ArrayList());
        }
        res.get(level).add(root.val);
        level(root.left, res, level+1);
        level(root.right, res, level+1);
    }
}