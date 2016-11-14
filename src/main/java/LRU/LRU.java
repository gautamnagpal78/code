package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnagpal on 11/3/16.
 */
public class LRU {
    public class LRUCache {
        int capacity;
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        Node head=null;
        Node end=null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node n = map.get(key);
                remove(n);
                setHead(n);
                return n.val;
            }

            return -1;
        }

        public void remove(Node n){
            if(n.prev!=null){
                n.prev.next = n.next;
            }else{
                head = n.next;
            }

            if(n.next!=null){
                n.next.prev = n.prev;
            }else{
                end = n.prev;
            }

        }

        public void setHead(Node n){
            n.next = head;
            n.prev = null;

            if(head!=null)
                head.prev = n;

            head = n;

            if(end == null)
                end = head;
        }

        public void set(int key, int value) {
            if(map.containsKey(key)){
                Node old = map.get(key);
                old.val = value;
                remove(old);
                setHead(old);
            }else{
                Node created = new Node(key, value);
                if(map.size()>=capacity){
                    map.remove(end.key);
                    remove(end);
                    setHead(created);

                }else{
                    setHead(created);
                }

                map.put(key, created);
            }
        }
    }
}
