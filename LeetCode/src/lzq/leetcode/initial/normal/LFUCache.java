package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	private CacheElement head = null;
    private int capacity = 0;
    private HashMap<Integer, Integer> valueHash = null;
    private HashMap<Integer, CacheElement> cache = null;
    
    public LFUCache(int _capacity) {
        capacity = _capacity;
        valueHash = new HashMap<Integer, Integer>();
        cache = new HashMap<Integer, CacheElement>();
    }
    
    public int get(int key) {
        if (valueHash.containsKey(key)) {
            refreshUsage(key);
            return valueHash.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if ( capacity == 0 ) return;
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if (valueHash.size() < capacity) {
                valueHash.put(key, value);
            } else {
                removeOne();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        refreshUsage(key);
    }
    
    private void addToHead(int key) {
        if (head == null) {
            head = new CacheElement(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            CacheElement element = new CacheElement(0);
            element.keys.add(key);
            element.next = head;
            head.prev = element;
            head = element;
        } else {
            head.keys.add(key);
        }
        cache.put(key, head);      
    }
    
    private void refreshUsage(int key) {
        CacheElement element = cache.get(key);
        element.keys.remove(key);
        
        if (element.next == null) {
            element.next = new CacheElement(element.count+1);
            element.next.prev = element;
            element.next.keys.add(key);
        } else if (element.next.count == element.count+1) {
            element.next.keys.add(key);
        } else {
            CacheElement tmp = new CacheElement(element.count+1);
            tmp.keys.add(key);
            tmp.prev = element;
            tmp.next = element.next;
            element.next.prev = tmp;
            element.next = tmp;
        }

        cache.put(key, element.next);
        if (element.keys.size() == 0) remove(element);
    }
    
    private void removeOne() {
        if (head == null) return;
        int old = 0;
        for (int n: head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) remove(head);
        cache.remove(old);
        valueHash.remove(old);
    }
    
    private void remove(CacheElement element) {
        if (element.prev == null) {
            head = element.next;
        } else {
            element.prev.next = element.next;
        } 
        if (element.next != null) {
            element.next.prev = element.prev;
        }
    }
    
    class CacheElement {
        public int count = 0;
        public LinkedHashSet<Integer> keys = null;
        public CacheElement prev = null, next = null;
        
        public CacheElement(int count) {
            this.count = count;
            keys = new LinkedHashSet<Integer>();
            prev = next = null;
        }
    }

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(10);

		cache.put(10, 13);
		cache.put(3, 17);
		cache.put(6, 11);
		cache.put(10, 5);
		cache.put(9, 10);
		System.out.println(cache.get(13)); // returns -1 (not found)

		cache.put(2, 19);
		System.out.println(cache.get(2)); // returns 3
		System.out.println(cache.get(3)); // returns 3
		
		cache.put(5, 25);
		System.out.println(cache.get(8)); // returns 3
		
		
		cache.put(9, 22);
		cache.put(5, 5);
		cache.put(1, 30);
		System.out.println(cache.get(11)); // returns 3
		
		cache.put(9, 12);
		System.out.println(cache.get(7)); // returns 3
		System.out.println(cache.get(5)); // returns 3
		System.out.println(cache.get(8)); // returns 3
		System.out.println(cache.get(9)); // returns 3

		cache.put(4, 30);
		cache.put(9, 3);
		System.out.println(cache.get(9)); // returns 3
		System.out.println(cache.get(10)); // returns 3
		System.out.println(cache.get(10)); // returns 3

		cache.put(6, 14);
		cache.put(3, 1);
		System.out.println(cache.get(3)); // returns 3

		cache.put(10, 11);
		System.out.println(cache.get(8)); // returns 3

		cache.put(2, 14);
		System.out.println(cache.get(1)); // returns 3
		System.out.println(cache.get(5)); // returns 3
		System.out.println(cache.get(4)); // returns 3

		cache.put(11, 4);
		cache.put(12, 24);
		cache.put(5, 18);
		System.out.println(cache.get(13)); // returns 3

		cache.put(7, 23);
		System.out.println(cache.get(8)); // returns 3
		System.out.println(cache.get(12)); // returns 3
		
		cache.put(3, 27);
		cache.put(2, 12);
		System.out.println(cache.get(5)); // returns 3
		
		cache.put(2, 9);
		cache.put(13, 4);
		cache.put(8, 18);
		cache.put(1, 7);
		System.out.println(cache.get(6)); // returns 3
		
		cache.put(9, 29);
		cache.put(8, 21);
		System.out.println(cache.get(5)); // returns 3
		
		cache.put(6, 30);
		cache.put(1, 12);
		System.out.println(cache.get(10)); // returns 3
		
		cache.put(4, 15);
		cache.put(7, 22);
		cache.put(11, 26);
		cache.put(8, 17);
		cache.put(9, 29);
		System.out.println(cache.get(5)); // returns 3
		
		cache.put(3, 4);
		cache.put(11, 30);
		System.out.println(cache.get(12)); // returns 3
		
		cache.put(4, 29);
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(9)); // returns 3
		System.out.println(cache.get(6)); // returns 3
		
		cache.put(3, 4);
		System.out.println(cache.get(1)); // returns 3
		System.out.println(cache.get(10)); // returns 3
		
		cache.put(3, 29);
		cache.put(10, 28);
		cache.put(1, 20);
		cache.put(11, 13);
		System.out.println(cache.get(3)); // returns 3
		
		cache.put(3, 12);
		cache.put(3, 8);
		cache.put(10, 9);
		cache.put(3, 26);
		System.out.println(cache.get(8)); // returns 3
		System.out.println(cache.get(7)); // returns 3
		System.out.println(cache.get(5)); // returns 3
		

		cache.put(13, 17);
		cache.put(2, 27);
		cache.put(11, 15);
		System.out.println(cache.get(12)); // returns 3
	}

}
