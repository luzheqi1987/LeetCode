package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * @author LuZheqi
 * 
 */
public class LRUCache {

	private int capacity;
	private Map<Integer, Entry> nodes;
	private int currentSize;
	private Entry first;
	private Entry last;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		currentSize = 0;
		nodes = new HashMap<Integer, Entry>();
	}

	public int get(int key) {
		Entry node = nodes.get(key);
		if (node != null) {
			moveToHead(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		Entry node = nodes.get(key);
		if (node == null) {
			if (currentSize >= capacity) {
				nodes.remove(last.key);
				removeLast();
			} else {
				currentSize++;
			}
			node = new Entry();
		}

		if (currentSize == 1) {
			first = node;
			last = node;
		}

		node.key = key;
		node.value = value;
		moveToHead(node);
		nodes.put(key, node);
	}

	private void moveToHead(Entry node) {
		if (node == first)
			return;

		// delete current node from doubly linked list
		if (node.pre != null) {
			node.pre.next = node.next;
		}
		if (node.next != null) {
			node.next.pre = node.pre;
		}

		if (last == node) {
			last = node.pre;
		}

		if (first != null) {
			node.next = first;
			first.pre = node;
		}
		first = node;
		node.pre = null;

	}

	private void removeLast() {
		if (last != null) {
			if (last.pre != null) {
				last.pre.next = null;
			} else {
				first = null;
			}
			last = last.pre;
		}
	}
}

class Entry {
	Entry pre;
	Entry next;
	int key;
	int value;
}