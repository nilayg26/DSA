package JAVA_DSA.Graphs.LeetCodeGraphs;
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
//Bellman Ford 
public class CheapestFlightKstops {
    
}
class Solution {
    int c;
    int n;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        c=flights.length;
        this.n=n;
        if(dst>n-1||src>n-1){
            return -1;
        }
        return bellManFord(flights,src,dst,k);
    }
    private int bellManFord(int [][] flights,int src, int dst, int k){
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        int temp_dis[]=new int [n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
            temp_dis[i]=Integer.MAX_VALUE;
        }
        dis[src] = 0;
        temp_dis[src]=0;
        for(int i=0;i<n;i++){
                temp_dis[i]=dis[i];
        }
        for(int f=0;f<k+1;f++){
            for(int i=0;i<c;i++){
                int u=flights[i][0];
                int v=flights[i][1];
                if(dis[u]!=Integer.MAX_VALUE&&dis[u]+flights[i][2]<temp_dis[v]){
                    temp_dis[v]=dis[u]+flights[i][2];
                }
            }
           for(int i=0;i<n;i++){
                dis[i]=temp_dis[i];
            }
        }
        if(dis[dst]!=Integer.MAX_VALUE){
            return dis[dst];
        }
       return -1;
    }
}
