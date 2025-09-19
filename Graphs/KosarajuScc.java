package JAVA_DSA.Graphs;

import java.util.*;

public class KosarajuScc {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[]=new ArrayList[5];
        createGraph(graph);
        printScc(5, graph);
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    private static void dfs(boolean vis[],int curr,ArrayList<Edge> graph[]){
        if(vis[curr]){
            return;
        }
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            dfs(vis, e.dest, graph);
        }

    }
    private static void topSort(boolean vis[],int curr,ArrayList<Edge> graph[],Stack<Integer> s){
        if(vis[curr]){
            return ;
        }
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            topSort(vis, e.dest, graph,s);
        }
        s.push(curr);
    }
    private static void transpose(ArrayList<Edge> graph[],ArrayList<Edge> transpose[],int V){
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
    }
    public static void printScc(int V,ArrayList<Edge> graph[] ){
        boolean vis[]=new boolean[V];
        //Step 1: TopSort
        Stack<Integer> s= new Stack<>();
        topSort(vis, 0, graph, s);
        //Step 2: Transpose
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<>();
        }
        transpose(graph, transpose, V);
        //Step 3: DFS using stack & transpose 
        while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                dfs(vis, curr, transpose);
                System.out.println();
            }
        }
    }
}
