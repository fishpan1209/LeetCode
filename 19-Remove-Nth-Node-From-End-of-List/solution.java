/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
    
        ListNode cur = head;
        int len=0;
        while(cur!=null){
            cur = cur.next;
            len++;
        }
        System.out.println(len);
        if(len==n) return head.next;
        
        ListNode pre = head;
        for(int i=0; i<len-n-1; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next==null? null : pre.next.next;
        return head;
    }
}