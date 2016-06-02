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
        List<List<Integer>> res = new ArrayList();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> cur = new ArrayList();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                cur.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(cur);
        }
        List<List<Integer>> result = new ArrayList();
        for(int i=res.size()-1; i>=0;i--){
            result.add(res.get(i));
        }
        return result;
    }
}