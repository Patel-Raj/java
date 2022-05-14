package disjointset;

public class DisjointSetMain {
    public static void main(String[] args) {
        int V = 5;

        DisjointSet dus = new DisjointSet(5);
        dus.union(0, 2);
        dus.union(4, 2);
        dus.union(3, 1);

        System.out.println(dus.find(4) == dus.find(0));
        System.out.println(dus.find(1) == dus.find(0));
    }
}

class DisjointSet {
    int V;
    int parent[];

    public DisjointSet(int V) {
        this.V = V;
        parent = new int[V];
        for(int i = 0 ; i < V; i++) parent[i] = i;
    }

    public int find(int node) {
        if(parent[node] == node)    return node;
        int p = find(parent[node]);
        parent[node] = p;
        return p;
    }

    public void union(int u, int v) {
        int p1 = find(u);
        int p2 = find(v);

        parent[p2] = p1;
    }
}