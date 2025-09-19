// https://leetcode.com/problems/rotting-oranges/
package JAVA_DSA.Graphs.LeetCodeGraphs;
import java.util.LinkedList;
import java.util.Queue;
//bfs
public class RottenOranges {
    
}
class Solution {
    static int []r={0,1,0,-1};
    static int []c={1,0,-1,0};
    static boolean vis[][];
    static int m;
    static int n;
    public int orangesRotting(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        vis=new boolean [m][n];
        boolean is=false;
        int count =bfs(grid);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&!vis[i][j]){
                    return -1;
                }
            }
        }
        return count;
    }
    private boolean check(int[][]grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n){
            return false;
        }
        if(grid[i][j]==0){
            return false; 
        }
        if(vis[i][j]){
            return false;
        }
        return true;
    }
    private int [] search2(int [][]grid){
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    return new int []{i,j};
                }
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        if(count!=0){
           return new int []{-1,-1};
        }
        else{
            return new int []{-2,-2};
        }
        
    }
    private void addToQ(int [][]grid,Queue<int []>q,boolean [][]vis){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
    }
    private int bfs(int [][]grid){
        Queue<int []> q=new LinkedList<int []>();
        int[] arr= search2(grid);
        if(arr[0]==-1){
            return -1;
        }
        if(arr[0]==-2){
            return 0;
        }
        addToQ(grid,q,vis);
        q.add(null);
        int count=0;
        while(!q.isEmpty()){
           int [] curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    return count;
                }
                else{
                    count++;
                    q.add(null);
                }
            }
            else{
            for(int t=0;t<4;t++){
                if(check(grid,curr[0]+r[t],curr[1]+c[t])){
                    vis[curr[0]+r[t]][curr[1]+c[t]]=true; 
                  q.add(new int[]{curr[0]+r[t],curr[1]+c[t]});
                }
            }
            }
        }
        return count;
    }
}
