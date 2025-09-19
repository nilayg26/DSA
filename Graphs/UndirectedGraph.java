package JAVA_DSA.Graphs;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Queue;

public class UndirectedGraph {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph [0].add (new Edge( 0,1)); 
        graph [0].add (new Edge( 0, 2));

        graph [1].add (new Edge(1, 0)); 
        graph [1].add (new Edge( 1, 3));

        graph[2].add (new Edge(2, 0)); 
      //  graph[2].add (new Edge(2,4));

        graph [3]. add (new Edge( 3,  1)); 
        graph [3]. add (new Edge( 3,4));
        graph [3]. add (new Edge( 3, 5));

      //  graph [4]. add (new Edge( 4,  2)); 
        graph [4]. add (new Edge( 4,3));
        graph [4]. add (new Edge( 4, 5));

        graph [5]. add (new Edge( 5,  3)); 
        graph [5]. add (new Edge( 5,4));
        graph [5]. add (new Edge( 5, 6));

        graph[6].add(new Edge(6, 5));
    }
    public static void bfs(ArrayList<Edge> graph[],int curr,boolean vis[]){ //O(V+E)
        Queue<Integer> q= new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty()){
            curr= q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){ //O(V+E)
        if(vis[curr]){
            return ;
        }
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            dfs(graph, e.dest, vis);
        }
        return;
    }
    //This is for directed Graphs only
    
    //O(V^V)
    public static void srcToTar(String str,ArrayList<Edge> graph[],int src,int tar,boolean vis[]){
        if(vis[src]){
            return;
        }
        if(src==tar){
            System.out.println(str+tar);
            return;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e= graph[src].get(i);
            srcToTar(str+String.valueOf(e.src), graph, e.dest, tar, vis);
        }
        vis[src]=false;
        return;

    }
    public static boolean deteCycle(ArrayList<Edge> graph[],int curr,boolean vis[],int parent){
        if(vis[curr]){
            return false;
        }
        boolean res=false;
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            System.out.println(e.dest);
            res=deteCycle(graph,e.dest, vis,curr);
            if(vis[e.dest]&&parent!=e.dest){
                return true;
            }
            if(res){
                return true;
            }
        }
        return false;
    }
    public static void main(String []args){
        int v=7;
        ArrayList<Edge> graph[]= new ArrayList[v];
        createGraph(graph);
       boolean vis[]= new boolean [v];
        for(int i=0;i<v;i++){
            vis[i]=false;
        }
        boolean rs[]=new boolean[v];
        for(int i=0;i<v;i++){
            rs[i]=false;
        }
        System.out.println(deteCycle(graph, 0, vis, -1));
      //  System.out.println(deteCycle(graph, 0, vis, rs));
       /* for(int i=0;i<v;i++){//This loop ensures that all the parts of a 
                              //disconnected graph are also covered
           if(!vis[i]){                   
           //bfs(graph, i, vis);
         //    dfs(graph, i, vis);
           }
        }*/
      //  srcToTar("", graph, 0, 5, vis);
    }   
}

