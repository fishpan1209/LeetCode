/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast.next!=null && fast.next.next!=null){
            if(slow==fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next==null || fast.next.next==null) return null;
        ListNode cur = head;
        while(slow!=cur){
            slow = slow.next;
            cur = cur.next;
            
        }
        return slow;
    }
}