package JAVA_DSA.Graphs;
import java.util.ArrayList;
public class Tarjans {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getBridge(V, graph);
        getArticulationPoint(V, graph);
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
      //  graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));
        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }
    //O(V+E)
    private static void dfs(int V,ArrayList<Edge> graph[],boolean []vis,int []dt,int []low,int curr, int par,int time){
        if(vis[curr]){
            return;
        }
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(e.dest==par){
                continue;
            }
            else if(!vis[e.dest]){
                dfs(V, graph, vis, dt, low, e.dest, curr, time);
                low[curr]=Math.min(low[curr], low[e.dest]);//Impt step
                if(dt[curr]<low[e.dest]){ //Impt Step
                    System.out.println("Bridge exists at: "+curr+"<--->"+e.dest);
                }
            }
            else{
                low[curr]=Math.min(low[curr], dt[e.dest]);
            }
        }
    }
    //O(V+E)
    private static void dfs(int V,ArrayList<Edge> graph[],boolean []vis,int []dt,int []low,int curr, int par,int time,boolean []ap){
        if(vis[curr]){
            return;
        }
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(e.dest==par){
                continue;
            }
            else if(!vis[e.dest]){
                dfs(V, graph, vis, dt, low, e.dest, curr, time,ap);
                low[curr]=Math.min(low[curr], low[e.dest]);
                if(dt[curr]<=low[e.dest]&&par!=-1){
                   ap[curr]=true;
                }
                children++;
            }
            else{
                low[curr]=Math.min(low[curr], dt[e.dest]);
            }
        }
        if(par==-1&&children>1){
            ap[curr]=true;
        }
    }
    public static void getBridge(int V, ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[V];
        int dt[]=new int [V];
        int low[]=new int [V];
        dfs(V, graph, vis, dt, low, 0, -1, 0);
    }
    public static void getArticulationPoint(int V, ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[V];
        int dt[]=new int [V];
        int low[]=new int [V];
        boolean ap[]=new boolean [V];
        dfs(V, graph, vis, dt, low, 0, -1, 0,ap);
        for(int i=0;i<V;i++){
            if(ap[i]){
                System.out.println(i+" is an articulation point");
            }
        }
    }
}
