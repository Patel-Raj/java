package interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ShortestPath {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 5;


        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(0, 1,adj);
        addEdge(1, 0,adj);
        addEdge(0, 2,adj);
        addEdge(2, 0,adj);
        addEdge(0, 3,adj);
        addEdge(3, 0,adj);
        addEdge(1, 2,adj);
        addEdge(2, 1,adj);
        addEdge(2, 3,adj);
        addEdge(3, 2,adj);
        addEdge(0, 4,adj);
        addEdge(4, 0,adj);
        addEdge(4, 3,adj);
        addEdge(3, 4,adj);

        Deque<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        boolean[] vis = new boolean[V];
        vis[0] = true;
        while(!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            if(curr.v == 3) {
                System.out.println("Min distance = " + curr.d);
                break;
            } else {
                for(int i = 0 ; i < adj.get(curr.v).size(); i++) {
                    int nxt = adj.get(curr.v).get(i);
                    if(!vis[nxt]) {
                        queue.addLast(new Node(nxt, curr.d+1));
                    }
                }
            }
        }
    }
    public static void addEdge(int u, int v, List<List<Integer>> adj) {
        adj.get(u).add(v);
    }

}

class Node {
    public int v;
    public int d;

    public Node(int v, int d) {
        this.v = v;
        this.d = d;
    }
}