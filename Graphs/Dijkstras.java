package JAVA_DSA.Graphs;

import java.util.*;

public class Dijkstras {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int n, int path) {
            this.node = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;// ascending
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    //O(E+ ElogV)
    //Works only when weight of every edge > 0
    public static void dijktras(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                System.out.print(curr.node+" -> ");
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (dis[u] + e.wt < dis[v]) { //Relaxation Step or Greedy Step
                        dis[v] = dis[u] + e.wt;  
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }
        // for (int i = 0; i < V; i++) {
        //     System.out.println(src + "->" + i + "= " + dis[i]);
        // }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Shortest Distances are: ");
        dijktras(graph, 0, V);
    }
}
