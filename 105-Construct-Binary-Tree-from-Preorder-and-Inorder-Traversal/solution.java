/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashMap;
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length-1, map, 0, inorder.length-1);
        return root;
    }
    
    public TreeNode build(int[] preorder, int prestart, int preend, HashMap<Integer, Integer> map, int instart, int inend){
        if(prestart>preend || instart>inend) return null;
        int val = preorder[prestart];
        TreeNode root = new TreeNode(val);
        int inroot = map.get(val);
        int inleft = map.get(val)-instart; // number of left nodes
        
        // use [instart, inroot-1] from inorder to build left nodes
        root.left = build(preorder,prestart+1, prestart+inleft, map, instart, inroot-1 );
        // use [inroot+1, inend] from inorder to build right nodes
        root.right = build(preorder,prestart+inleft+1, preend, map, inroot+1, inend );
        return root;
    }
}