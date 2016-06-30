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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if(root==null) return res;
        List<Integer> cur = new ArrayList();
        pathSum(root, sum, cur, res);
        return res;
    }
    
    public void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res){
        if(root==null) return;
        cur.add(root.val);
        if(root.left==null && root.right==null && root.val==sum) {
            res.add(new ArrayList(cur));
            cur.remove(cur.size()-1);
            return;
        }
        else {
            pathSum(root.left, sum-root.val, cur, res);
            pathSum(root.right, sum-root.val, cur, res);
        }
        cur.remove(cur.size()-1);
    }
}