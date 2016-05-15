/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        
        // count length
        int len = 1;
        while(fast.next!=null){
            len++;
            fast = fast.next;
        }
        
        // move slow to new head
        for( int i=1; i<len-k%len; i++){
            slow = slow.next;
        }
        
        // rotate
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
 
}