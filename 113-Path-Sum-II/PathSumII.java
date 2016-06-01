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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        path(root, sum, res, cur);
        return res;
    }
    
    public void path(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur){
        if(root == null) return;
        cur.add(root.val);
        sum -= root.val;
        if(sum==0 && root.left==null && root.right==null) {
            res.add(new ArrayList(cur));
            // remove the last node
            cur.remove(cur.size()-1);
            return;
        }
        if(root.left!=null) {
            path(root.left, sum, res, cur);
        }
        if(root.right!=null) {
            path(root.right, sum, res, cur);
        }
        cur.remove(cur.size()-1);
        
    }
}