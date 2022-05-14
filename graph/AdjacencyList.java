package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    public static void main(String args[]) {
        Graph graph = new Graph(5);
        int vertices = 4;

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.bfs(2);
        System.out.println();
        graph.dfs(1, new boolean[4]);
    }


}

class Graph {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        for(int i = 0 ; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void printIt() {
        for(int i =0 ; i < adj.size(); i++) {
            for(int j = 0 ; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[vertices];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int i = 0 ; i < adj.get(curr).size(); i++) {
                if(!visited[adj.get(curr).get(i)]) {
                    visited[adj.get(curr).get(i)] = true;
                    queue.add(adj.get(curr).get(i));
                }
            }
            System.out.print(curr + " ");
        }
    }

    public void dfs(int start, boolean visited[]) {
        if(visited[start]) return;
        System.out.print(start + " ");
        visited[start] = true;
        for(int i = 0 ; i < adj.get(start).size(); i++) {
            if(!visited[adj.get(start).get(i)]) {
                dfs(adj.get(start).get(i), visited);
            }
        }
    }
}