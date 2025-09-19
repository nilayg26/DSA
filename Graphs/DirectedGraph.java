package JAVA_DSA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import JAVA_DSA.Graphs.UndirectedGraph.Edge;

public class DirectedGraph {
    public static void main(String [] args){
        int v=7;
        ArrayList<Edge> direcredGraph[]= new ArrayList[v];
        createGraph(direcredGraph);
        boolean vis[]= new boolean [v];
        // for(int i=0;i<v;i++){
        //     vis[i]=false;
        // }
        // boolean rs[]=new boolean[v];
        // for(int i=0;i<v;i++){
        //     rs[i]=false;
        // }
        // System.out.println(deteCycle(direcredGraph, 0, vis, rs));
        createGraph(direcredGraph);
        Stack<Integer> s= new Stack<>();
        topologicalSort(direcredGraph, 0, vis, s);
        while(!s.empty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // graph [0].add (new Edge( 0,1)); 
        // graph [1].add (new Edge( 1, 3));
        // graph[2].add (new Edge(2,4));
        // graph [3]. add (new Edge( 3, 5));
        // graph [4]. add (new Edge( 4, 5));
        // graph [5]. add (new Edge( 5, 6));
        // graph[6].add(new Edge(6, 1));
         graph [0].add (new Edge( 0,1)); 
         graph [0].add (new Edge( 0,2));
         graph [1].add (new Edge( 1, 3));
         graph[2].add (new Edge(2,4));
         graph [3]. add (new Edge( 3, 5));
         graph [4]. add (new Edge( 4, 5));
         graph [5]. add (new Edge( 5, 6));
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
    //works only for dag
    public static void topologicalSort(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer>s){
        if(vis[curr]){
            return;
        }
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            System.out.println(e.dest);
            topologicalSort(graph, e.dest, vis, s);
        }
        s.push(curr);
    }
    //O(v+e)
    public static boolean deteCycle(ArrayList<Edge> graph[],int curr,boolean vis[],boolean []rs){
        if(vis[curr]){
            return false;
        }
        boolean res=false;
        vis[curr]=true;
        rs[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            System.out.println(e.dest);
            res= deteCycle(graph, e.dest, vis, rs);
            if(rs[e.dest]){
                return true;
            }
            if(res){
                return true;
            }
        }
        rs[curr]=false;
        return res;
    }
}
