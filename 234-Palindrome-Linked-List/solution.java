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
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next==null? null : fast.next.next;
        }
        
        // reverse first half
        ListNode p1=head;
        ListNode p2=head.next;
        head.next=null;
        while(p2!=slow){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        // odd length
        if(fast!=null) slow = slow.next;
        while(slow!=null){
            if(p1.val!=slow.val) return false;
            p1 = p1.next;
            slow = slow.next;
        }
        return true;
    }
}