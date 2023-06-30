package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DQNode {
        DQNode pre;
        DQNode next;
        int key;
        int value;

        public DQNode() {
        }

        public DQNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private DQNode head = new DQNode();
    private DQNode tail = new DQNode();
    private int capacity;

    private Map<Integer, DQNode> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DQNode node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            DQNode node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            node.value = value;
            return;
        }

        if (map.size() >= capacity){
            DQNode n = head.next;
            head.next = head.next.next;
            head.next.pre = head;

            n.pre = null;
            n.next = null;
            map.remove(n.key);
        }

        DQNode node = new DQNode(key,value);

        if(head.next == tail){
            head.next = node;
            node.pre = head;
            node.next = tail;
            tail.pre = node;
        }else{
            node.pre = tail.pre;
            tail.pre.next = node;
            node.next = tail;
            tail.pre = node;
        }
        map.put(key,node);
    }
}
