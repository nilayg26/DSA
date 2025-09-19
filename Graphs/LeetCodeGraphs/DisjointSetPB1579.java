package JAVA_DSA.Graphs.LeetCodeGraphs;
//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/
public class DisjointSetPB1579 {
    
}
class Solution {
    int n;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        this.n=n;
        int res= cal(edges);
        return res;
    }
    private void helper(int []parent,int []rank,int u,int v){
        int curr=parent[v];
        rank[u]++;
        parent[v]=parent[u];
        for(int i=1;i<n+1;i++){
            if(parent[i]==curr){
                parent[i]=parent[u];
            }
        }
    }
    private int cal(int [][]edges){
        boolean vis []=new boolean[n];
        int []ranka = new int [n+1];
        int []parenta=new int [n+1];
        int []rankb = new int [n+1];
        int []parentb=new int [n+1];
        for(int i=1;i<n+1;i++){
            ranka[i]=0;
            rankb[i]=0;
            parenta[i]=i;
            parentb[i]=i;
        }
        int j=0,k=0;
        int a=0;
        int b=0;
        int c=0;
        for(int i=0;i<edges.length;i++){
            int u=edges[i][1];
            int v=edges[i][2];
            if(edges[i][0]==3){
                c++;
                if(ranka[u]>=ranka[v]){
                   helper(parenta,ranka,u,v);
                }
                else{
                    helper(parenta,ranka,v,u);
                }
                if(rankb[u]>=rankb[v]){
                   helper(parentb,rankb,u,v);
                }
                else{
                    helper(parentb,rankb,v,u);
                }
            }
            if(edges[i][0]==1){
               a++;
                if(ranka[u]>=ranka[v]){
                   helper(parenta,ranka,u,v);
                }
                else{
                    helper(parenta,ranka,v,u);
                }
            }
             if(edges[i][0]==2){
                b++;
                if(rankb[u]>=rankb[v]){
                   helper(parentb,rankb,u,v);
                }
                else{
                    helper(parentb,rankb,v,u);
                }
            }
        }
        for(int i=1;i<n;i++){
            if(parenta[i]!=parenta[i+1]||parentb[i]!=parentb[i+1]){
                return -1;
            }
        }
        return a+b+(2*c)-(2*(n-1));
    }
}
