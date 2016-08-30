public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> hash;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        hash = new HashMap<Integer, Node>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        }
        Node curr = hash.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        moveToTail(curr);
        return curr.value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            hash.get(key).value = value;
            return;
        }
        if (hash.size() == capacity) {
            hash.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        hash.put(key, insert);//¿œÕ¸º«º”»Îhash
        moveToTail(insert);
    }
    
    private void moveToTail(Node curr) {
        curr.prev = tail.prev;
        curr.next = tail;
        curr.prev.next = curr;
        tail.prev = curr;
    }
}

