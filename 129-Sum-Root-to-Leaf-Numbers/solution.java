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
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        List<Integer> sum = new ArrayList();
        sumNumbers(root, sum, 0);
        int res=0;
        for(Integer i : sum){
            res += i;
        }
        return res;
    }
    
    public void sumNumbers(TreeNode root, List<Integer> sum, int cur){
        if(root==null) return;
        if(root.left==null && root.right==null){
            cur =cur*10 + root.val;
            sum.add(cur);
            cur = 0;
            return;
        }
        cur = cur*10 + root.val;
        sumNumbers(root.left, sum, cur);
        sumNumbers(root.right, sum, cur);
    }
}