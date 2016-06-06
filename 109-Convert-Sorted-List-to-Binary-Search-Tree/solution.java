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
    
    private static class State {
        ListNode head;
        State(ListNode head) {
            this.head = head;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(size(head), new State(head));
    }
    private TreeNode sortedListToBST(int size, State state) {
        if (size<=0) return null;
        int mid = size/2;
        TreeNode root = new TreeNode(0);
        root.left = sortedListToBST(mid, state);
        root.val = state.head.val;
        state.head = state.head.next;
        root.right = sortedListToBST(size - mid - 1, state);
        return root;
    }
    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}