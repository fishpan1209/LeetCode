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
        return sortedArrayToBST(0, nums.length-1, nums);
    }
    
    public TreeNode sortedArrayToBST(int start, int end, int[] nums){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(start, mid-1, nums);
        root.right = sortedArrayToBST(mid+1, end, nums);
        return root;
    }
}