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
        if(head==null || head.next==null) return head;
        int len=0;
        ListNode count = head;
        while(count!=null){
            count = count.next;
            len++;
        }
        k = k%len;
        ListNode slow = head;
        ListNode fast = head;
        ListNode fakehead = head;
        ListNode res = head;
        int i=0;
        while(i<k) {
            if(fast.next==null) return head;
            fast=fast.next;
            i++;
        }
        while(fast.next!=null){
           
            slow = slow.next;
            fast = fast.next;
            
        }
        fast.next = fakehead;
        res = slow.next;
        slow.next = null;
        return res;
        
    }
}