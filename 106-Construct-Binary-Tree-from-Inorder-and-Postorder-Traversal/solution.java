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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(map, 0, inorder.length-1, postorder,0, postorder.length-1);
        return root;
    }
    
    public TreeNode build(HashMap<Integer, Integer> map, int instart, int inend, int[] postorder, int pstart, int pend){
        if(instart>inend || pstart>pend) return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int inroot = map.get(postorder[pend]);
        int inleft = inroot - instart;
        root.left = build(map, instart, inroot-1, postorder, pstart, pstart+inleft-1);
        root.right = build(map, inroot+1, inend, postorder, pstart+inleft , pend-1 );
        return root;
    }
}