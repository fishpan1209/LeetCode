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
    private int max=0;
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        longest(root, 0, root.val);
        return max;
    }
    
    public void longest(TreeNode root, int cur, int prev){
        if(root==null) return;
        if(root.val==prev) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        
        longest(root.left, cur, root.val+1);
        longest(root.right, cur, root.val+1);
       
    }
}