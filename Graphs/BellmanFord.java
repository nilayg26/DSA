package JAVA_DSA.Graphs;

import java.util.*;
public class BellmanFord {
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
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        //graph[4].add(new Edge(4, 1, -10));
        graph[4].add(new Edge(4, 1, -1));
    }
    //O(E*V)
    //Works for negative weight
    //Does not work for the concept of negative weight cycle
    public static void bellmamFord(ArrayList<Edge> graph[], int src, int V) {
        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        for(int i=0;i<V-1;i++){ 
            for(int j=0;j<V;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    if(dis[u]!=Integer.MAX_VALUE&&dis[u]+e.wt<dis[v]){
                        dis[v]=dis[u]+e.wt;
                    }
                }
            }
        }
         for (int i = 0; i < V; i++) {
             System.out.println(src + "->" + i + "= " + dis[i]);
         }
    }
    
    static boolean detectNegativeWeightCycle(ArrayList<Edge> graph[], int src, int V){
        boolean[] vis = new boolean[V];
        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src]=0;
        bellmamFord(graph, src, V);
            for(int j=0;j<V;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    if(dis[u]!=Integer.MAX_VALUE&&dis[u]+e.wt<dis[v]){
                        return true;
                    }
                }
            }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Shortest Distances are: ");
     //   bellmamFord(graph, 0, V);
        System.out.println(detectNegativeWeightCycle(graph,0,V));
    }
}


