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
        if(root==null) return res;
        zigzag(root, res, 0);
        return res;
    }
    
    public void zigzag(TreeNode root, List<List<Integer>> res,  int level){
        if(root==null) return;
        if(res.size()<=level){
            ArrayList cur = new ArrayList();
            res.add(cur);
        }
        List<Integer> temp = res.get(level);
    
        if(level>0 && level%2==0){
            temp.add(root.val);
        }
        else{
           temp.add(0, root.val);
        }
        zigzag(root.left, res, level+1);
        zigzag(root.right, res, level+1);
    }
}