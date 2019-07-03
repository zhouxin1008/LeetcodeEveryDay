import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
class No146LRUCache {
    class Node {
        Node pre = null;
        Node next = null;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.pre = this.head;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    private void insertNode(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        // node.pre = null;
        // node.next = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node val = map.get(key);
            deleteNode(val);
            insertNode(val);
            return val.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.val = value;
            deleteNode(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
            node = new Node(key, value);
        }
        insertNode(node);   
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

