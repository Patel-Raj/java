package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MST {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<Edge> edges = new ArrayList<>();

        for(int i = 0 ; i < V; i++) {
            for(int j = i+1; j < V; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges, (n1, n2) -> n1.d-n2.d);

        int parent[]= new int[V];
        for(int i =0 ; i < V; i++)  parent[i] = i;
        int counter = 0;
        int cost = 0;

        for(Edge edge : edges) {
            if(find(parent, edge.u) != find(parent, edge.v)) {
                union(parent, edge.u, edge.v);
                counter++;
                System.out.println(edge.u + " " + edge.v + " " + edge.d);
                cost += edge.d;
            }
            if(counter == V-1)    return cost;
        }
        return cost;
    }

    private int find(int[] parent, int vertex) {
        if(parent[vertex] == vertex)    return vertex;
        int p = find(parent, parent[vertex]);
        parent[vertex] = p;
        return p;
    }

    private void union(int[] parent, int u, int v) {
        int p1 = find(parent, u);
        int p2 = find(parent, v);
        parent[p1] = p2;
    }
}

class Edge {
    int u;
    int v;
    int d;

    public Edge(int u, int v , int d) {
        this.u = u;
        this.v = v;
        this.d = d;
    }

    private int[] test() {
        return new int[] {1,2};
    }
}