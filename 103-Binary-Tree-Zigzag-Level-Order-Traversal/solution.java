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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        zigzag(root, res, 0);
        return res;
    }
    
    public void zigzag(TreeNode root, List<List<Integer>> res, int level){
        if(root==null) return;
        if(res.size()<=level){
            List<Integer> cur = new ArrayList();
            res.add(cur);
        }
        List<Integer> cur = res.get(level);
        
        if(level%2==0){
            cur.add(root.val);
        }
        else cur.add(0, root.val);
        zigzag(root.left, res, level+1);
        zigzag(root.right, res, level+1);
       
    }
}