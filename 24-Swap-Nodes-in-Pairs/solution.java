/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        /*
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;
        ListNode cur = dummy.next;
        ListNode next = cur;
        ListNode pre = cur;
        while(cur!=null && cur.next!=null){
            pre = cur;
            next = cur.next;
            cur = cur.next.next==null ? null : cur.next.next;
            pre.next = cur;
            dummy.next = next;
            next.next = pre;
            dummy = pre;
        }
        return res.next;
        */
        
        // recursive
        ListNode second = head.next;
        head.next = swapPairs(head.next.next);
        second.next = head;
        return second;
    }
}