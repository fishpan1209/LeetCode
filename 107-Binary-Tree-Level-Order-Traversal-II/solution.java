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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrder(root, res, 0);
        List<List<Integer>> reverse = new ArrayList<List<Integer>>();
        for(int i=res.size()-1;i>=0; i--){
            reverse.add(res.get(i));
        }
        return reverse;
    }
    
    public void levelOrder(TreeNode root, List<List<Integer>> res, int level){
        if(root==null) return;
        if(res.size()<=level){
            List<Integer> cur = new ArrayList();
            res.add(cur);
        }
        
        List<Integer> cur = res.get(level);
        cur.add(root.val);
        levelOrder(root.left, res, level+1);
        levelOrder(root.right, res, level+1);
    }
}