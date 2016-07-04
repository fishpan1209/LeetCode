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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root==null) return res;
        findLeaves(root, res);
        return res;
        
    }
    
    public int findLeaves(TreeNode root, List<List<Integer>> res){
        if(root==null) return -1;
        int level = Math.max(findLeaves(root.left, res), findLeaves(root.right, res))+1;
        if(res.size()<=level){
            res.add(new ArrayList<Integer>());
        }
        List<Integer> cur = res.get(level);
        cur.add(root.val);
        return level;
    }
}