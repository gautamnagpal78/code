package Graphs;

import java.util.*;

/**
 * Created by gnagpal on 11/1/16.
 */


public class Solution {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
    static class Name{
        String x;

        public Name(String x) {
            this.x = x;
        }
    }

    public static void main(String[] args) {
        List<Name> list = new ArrayList<>();
        list.add(new Name("Gautam"));
        Name f = new Name("wef");
        list.add(f);
        list.add(f);
        System.out.println(list.contains(f));
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();

        LinkedList<UndirectedGraphNode> nqueue = new LinkedList<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        Map<Integer,UndirectedGraphNode> maps = new HashMap<>();

        queue.addLast(node);
        nqueue.addLast(head);
        maps.put(head.label,head);

        while(queue.size()!=0){
            UndirectedGraphNode qnode = queue.getFirst();
            UndirectedGraphNode q1node = nqueue.getFirst();
            queue.removeFirst();
            nqueue.removeFirst();

            List<UndirectedGraphNode> children = new ArrayList<>();
            for(UndirectedGraphNode node1 : qnode.neighbors){
                children.add(new UndirectedGraphNode(node1.label));
                queue.add(node1);
            }
            q1node.neighbors = children;
        }

        return head;
    }
}
