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
        else return toBST(0, nums.length-1, nums);
    }
    
    public TreeNode toBST(int start, int end, int[] nums){
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        // if start=end, add current node, then return
        if(start==end) {
            return root;
        }
        if(start>mid-1) root.left = null; // left boundary
        else {
            TreeNode left = toBST(start, mid-1, nums);
            root.left = left;
        }
        if(mid+1>end) root.right = null; // right boundary
        else {
            TreeNode right = toBST(mid+1, end, nums);
            root.right = right;
        }
        return root;
    }
}