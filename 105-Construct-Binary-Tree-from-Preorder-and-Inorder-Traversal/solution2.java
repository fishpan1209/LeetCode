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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int i = is;
        int count=0;
        while(inorder[i++]!=preorder[ps]) count++;
        System.out.println(count);
        root.left = buildTree(preorder, ps+1, ps+count, inorder, is, is+count);
        root.right = buildTree(preorder, ps+count+1, pe, inorder, is+count+1, ie);
        return root;
    }
}