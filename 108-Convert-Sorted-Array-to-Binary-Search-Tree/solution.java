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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if(start<0 || end>=nums.length || start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
}