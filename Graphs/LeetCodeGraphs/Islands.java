// https://leetcode.com/problems/number-of-islands/
//dfs 
package JAVA_DSA.Graphs.LeetCodeGraphs;
class Solution {
    static int []r={0,1,0,-1};
    static int []c={1,0,-1,0};
    static boolean [][]vis;
    static int m,n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=false;
            }
        }
        int count =0;
        for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
             if(check(i,j,grid)){
                dfs(grid,i,j);
                count++;
             }
          }
       }
       return count;
    }
    private boolean check(int i,int j,char[][]grid){
        if(i<0||j<0||i>=m||j>=n){
            return false;
        }
        if(grid[i][j]=='0'){
            return false;
        }
        if(vis[i][j]){
            return false;
        }
        return true;
    }
    private void dfs(char[][]grid,int i,int j){
        if(!check(i,j,grid)){ 
            return;
        }
        vis[i][j]=true;
        for(int t=0;t<4;t++){
            dfs(grid,i+r[t],j+c[t]);
        }
    }
}
public class Islands {
    
}
