import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */
class LFUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private Header head = new Header(1);
    private int capacity;

    class Node {
        int key;
        int value;
        Node pre = null;
        Node next = null;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class Header extends Node{
        int level;
        Header up = null;
        public Header(int level) {
            super(-1,-1);
            this.level = level;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        node.pre = null;
        node.next = null;
    }

    private void removeLast() {
        Header header = this.head;
        while (header!=null && header.next == null) {
            header = header.up;
        }
        Node node = header.next;
        while (node.next != null) {
            node = node.next;
        }
        map.remove(node.key);
        node.pre.next = null;
    }

    private void add(Header header, Node node) {
        if (header.next!=null) {
            header.next.pre = node;
        }
        node.next = header.next;
        node.pre = header;
        header.next = node;
    }

    private Header getHeader(Node node) {
        while (node instanceof Header == false) {
            node = node.pre;
        }
        return (Header)node;
    }
    
    public int get(int key) {
        if(capacity<=0) return -1;
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        Header header = getHeader(node);
        remove(node);
        if(header.up == null) {
            header.up = new Header(header.level + 1);
        }
        add(header.up, node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity<=0) return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            Header header = getHeader(node);
            remove(node);
            if(header.up == null) {
                header.up = new Header(header.level + 1);
            }
            add(header.up, node);
        } else {
            Node node = new Node(key, value);
            if(map.size() == capacity) {
               removeLast();
            }
            map.put(key, node);
            add(this.head, node);
        }   
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

