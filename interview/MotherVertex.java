package interview;

import java.util.ArrayList;
import java.util.List;

public class MotherVertex {
    public static void main(String[] args) {
        new MotherSolver().solve();
    }
}

class MotherSolver {
    public void solve() {
        int V = 7;
        int E = 8;

        List<List<Integer>> adj = new ArrayList<>();
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
        int probableMother = -1;
        for(int i  = 0 ; i < V; i++) {
            if(!vis[i]) {
                dfs(i, vis, adj);
                probableMother = i;
            }
        }

        if(probableMother != -1) {
            for(int i = 0; i < V; i++) {
                vis[i] = false;
            }
            dfs(probableMother, vis, adj);
            for(int i = 0; i < V; i++) {
                if(!vis[i]) {
                    System.out.println("No mother");
                    return;
                }
            }
            System.out.println("mother " + probableMother);
        } else {
            System.out.println("No mother");
        }

    }

    public void dfs(int v, boolean[] vis, List<List<Integer>> adj) {
        vis[v] = true;
        for(int i = 0 ; i < adj.get(v).size(); i++) {
            int curr = adj.get(v).get(i);
            if(!vis[curr]) {
                dfs(curr, vis, adj);
            }
        }
    }

    public void addEdge(int u, int v, List<List<Integer>> adj) {
        adj.get(u).add(v);
    }
}

class Student {
    public void getName() {

    }
}