package Graph;

/**
 * Created by gnagpal on 10/12/16.
 */
// A Java program to print topological sorting of a DAG
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency
// list representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    public int getV() {
        return V;
    }

    //Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj[v].add(w); }

    // A recursive function used by topologicalSort
    private static void topologicalSort(Graph g, int size){
        LinkedList<Integer> stack = new LinkedList<>();
        boolean visited[] = new boolean[size];

        for (int i = 0; i < size; i++)
            if (visited[i] == false)
                topo(g,i, visited, stack);

        while(stack.size()!=0){
            System.out.println(stack.getFirst());
            stack.removeFirst();
        }
    }

    private static void topo(Graph g, int v, boolean[] visited, LinkedList<Integer> stack) {
        if(!visited[v]){
            for(Integer child : g.adj[v]){
                topo(g,child,visited,stack);
            }

            visited[v] = true;
            stack.addFirst(v);

        }


    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort(g,6);
    }
}
