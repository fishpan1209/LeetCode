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
         List<List<Integer>> res = new ArrayList<List<Integer>>();
         if(root==null) return res;
         // use a queue to store all nodes
         Queue<TreeNode> q = new LinkedList();
         q.add(root);
         while(q.size()>0){
             List<Integer> cur = new ArrayList();
             // q.size changed in the loop
             int size = q.size();
             for(int i=0; i<size; i++){ 
                 TreeNode node = q.poll();
                 cur.add(node.val);
                 if(node.left!=null) q.add(node.left);
                 if(node.right!=null) q.add(node.right);
         }
         res.add(cur);
    }
    return res;
}
}