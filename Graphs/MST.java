package JAVA_DSA.Graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
public class MST {
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
        int parent;
        public Pair(int n, int path,int parent) {
            this.node = n;
            this.path = path;
            this.parent=parent;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;// ascending
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
        graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        }
    // E log E 
     public static int primsAlgo(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        int count=0;
        HashMap<Integer,int []> map=new HashMap<>();
        dis[src] = 0;
        pq.add(new Pair(src, 0,-1));
        while (!pq.isEmpty()) { 
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                map.put(curr.node,new int []{curr.parent,curr.path});
                count+=curr.path;
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int v = e.dest;
                    if(!vis[v]){
                       pq.add(new Pair(v, e.wt,curr.node));
                   }
                }
            }
        }
         for(int i=1;i<V;i++){
            if(map.containsKey(i)){
             System.out.println(map.get(i)[0]+" -> "+i+" wt is:"+map.get(i)[1]);
            }   
        }
        return count;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("MST cost is: ");
        System.out.println(primsAlgo(graph, 0, V));
    }
    
}
