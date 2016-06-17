/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        else if(l1==null) return l2;
        else if(l2==null) return l1;
        ListNode res = new ListNode(0);
        ListNode head = res; // have to record head of res, otherwise res will only be last node
        int carry = 0;
        while(l1!=null || l2!=null){
            
            if(l1!=null) {
                res.val+=l1.val;
                l1 = l1.next==null? null : l1.next;
            }
            if(l2!=null) {
                res.val+=l2.val;
                l2 = l2.next==null? null : l2.next;
            }
            
            res.val += carry;
            carry = res.val>=10? 1 : 0;
            
            res.val %= 10;
            
            
            if (l1!=null || l2!=null){
                res.next = new ListNode(0);
                res = res.next;
            }
            
        }
        if(carry>0) res.next = new ListNode(carry);
        return head;
    }
}