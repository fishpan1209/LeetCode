/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    // use a node, do not modify head
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        int n = size(head);
        node = head;
        return sortedListToBST(0, n-1);
    }
    
    public int size(ListNode head){
        // do not modify head
        ListNode fast = head;
        int count=1;
        while(fast.next!=null){
            count++;
            fast = fast.next;
        }
        return count;
    }
    
    public TreeNode sortedListToBST(int start, int end){
        if(start>end) return null;
    
        int mid = start+(end-start)/2;
        // inorder: left->root->right
        TreeNode left = sortedListToBST(start, mid-1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = sortedListToBST(mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}