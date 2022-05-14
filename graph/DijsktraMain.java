package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijsktraMain {
    public static void main(String[] args) {
        List<List<MyEdge>> adj = new ArrayList<>();
        int V = 6;

        for(int i = 0 ; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(0,1,5, adj);
        addEdge(0,2,1, adj);
        addEdge(1,2,2, adj);
        addEdge(1,3,1, adj);
        addEdge(1,4,2, adj);
        addEdge(2,4,3, adj);
        addEdge(3,5,2, adj);
        addEdge(3,4,4, adj);
        addEdge(4,5,3, adj);

        int source = 0;
        boolean[] vis = new boolean[V];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1,n2) -> n1.d - n2.d);
        priorityQueue.add(new Node(source, 0));

        int dist[] = new int[V];

        while(!priorityQueue.isEmpty()) {
            Node curr = priorityQueue.poll();
            if(vis[curr.v]) continue;
            vis[curr.v] = true;
            dist[curr.v] = curr.d;

            for(int i = 0; i < adj.get(curr.v).size(); i++) {
                int dest = adj.get(curr.v).get(i).v;
                if(vis[dest])   continue;
                int weight = adj.get(curr.v).get(i).d;
                priorityQueue.add(new Node(dest, curr.d + weight));
            }
        }
        for(int i = 0 ; i < V; i++) {
            System.out.println(dist[i]);
        }
    }

    public static void addEdge(int u, int v, int d, List<List<MyEdge>> adj) {
        adj.get(u).add(new MyEdge(u,v,d));
        adj.get(v).add(new MyEdge(v,u,d));
    }
}

class MyEdge{
    int u;
    int v;
    int d;

    public MyEdge(int u, int v, int d) {
        this.u = u;
        this.v = v;
        this.d = d;
    }
}

class Node {
    int v;
    int d;
    public Node(int v, int d) {

        this.v = v;
        this.d = d;
    }
}