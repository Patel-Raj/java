package interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GraphPath {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 7;
        int E = 8;

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(0, 1,adj);
        addEdge(0, 2,adj);
        addEdge(1, 3,adj);
        addEdge(4, 1,adj);
        addEdge(6, 4,adj);
        addEdge(5, 6,adj);
        addEdge(5, 2,adj);
        addEdge(6, 0,adj);

        boolean[] vis = new boolean[V];
        int source = 5, dest = 0;
        dfs(source, dest, adj, vis);
        System.out.println(vis[dest]);

        for(int i = 0; i < V; i++) {
            vis[i] = false;
        }
        int connectedComp = 0;
        int largestCompSize = 0;

        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                connectedComp++;
                int sz = simpleDfs(i, adj, vis);
                largestCompSize = Math.max(largestCompSize, sz);
            }
        }
        System.out.println(largestCompSize);
        for(int i = 0; i < V; i++) {
            vis[i] = false;
        }

    }

    public static void addEdge(int u, int v, List<List<Integer>> adj) {
        adj.get(u).add(v);
    }

    public static void dfs(int source, int dest, List<List<Integer>> adj, boolean[] vis) {
        if(vis[source] || vis[dest]) return;
        vis[source] = true;

        for(int i = 0 ; i < adj.get(source).size(); i++) {
            dfs(adj.get(source).get(i), dest, adj, vis);
        }
    }

    public static int simpleDfs(int source, List<List<Integer>> adj, boolean[] vis) {
        if(vis[source]) return 0;
        vis[source] = true;

        int count = 1;
        for(int i = 0 ; i < adj.get(source).size(); i++) {
            count += simpleDfs(adj.get(source).get(i), adj, vis);
        }
        return count;
    }
}