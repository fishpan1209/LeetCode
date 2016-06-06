/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        if(head.next.next==null) return head.val==head.next.val;
        ListNode slow=head, fast=head;
        ListNode pre = slow, after = slow.next;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            pre = slow;
            slow = after; 
            after = after.next;
            slow.next = pre;
        }
       
        // odd length
        if(fast.next==null) slow = slow.next;
       
        // slow can be the last node, so slow!=null instead of slow.next!=null
        while(after!=null){
            if(slow.val!=after.val) return false;
            slow = slow.next;
            after = after.next;
        }
        
        return true;
    }
}