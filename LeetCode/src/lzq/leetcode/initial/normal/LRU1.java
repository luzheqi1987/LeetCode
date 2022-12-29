package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

public class LRU1 {
    private final Map<String, Node> cache;
    private final Node head;
    private final Node tail;
    private final int capacity;
    private int currentSize;

    public LRU1(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.next = head;
        this.currentSize = 0;
        cache = new HashMap<>(capacity);
    }

    public void put(String key, String value) {
        Node existNode = cache.get(key);
        if (existNode == null) {
            if (currentSize >= capacity) {
                String lastKey = removeTail();
                cache.remove(lastKey);
                currentSize--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        } else {
            existNode.setVal(value);
            moveToHead(existNode);
        }
        currentSize++;
    }

    public String get(String key) {
        Node existNode = cache.get(key);
        if (existNode == null) {
            return null;
        } else {
            moveToHead(existNode);
            return existNode.val;
        }
    }

    public String removeTail() {
        Node last = tail.pre;
        last.pre.next = last.next;
        last.next.pre = last.pre;
        return last.key;
    }

    public void moveToHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = head.next;
        head.next = node;
        head.next.pre = node;
        node.pre = head;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        head.next = node;
        head.next.pre = node;
        node.pre = head;
    }

    class Node {
        String key;
        String val;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(String key, String value) {
            this.key = key;
            this.val = value;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }
}
