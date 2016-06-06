/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a==null? headB : a.next; // if a reaches end, point to headB, so the total len of a, b is the same, 
                                         // will meetat second iteration
            b = b==null? headA : b.next;
        }
        return a;
    }
}