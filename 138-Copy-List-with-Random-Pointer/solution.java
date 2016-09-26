/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;
        
        // put node, and its copy into a map
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        
        // first round, put all nodes and copy to map
        RandomListNode cur = head;
        while(cur!=null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        
        // second round, assign next and random
        cur = head;
        while(cur!=null){
            RandomListNode copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
