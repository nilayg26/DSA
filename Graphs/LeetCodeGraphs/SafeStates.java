// https://leetcode.com/problems/find-eventual-safe-states/
package JAVA_DSA.Graphs.LeetCodeGraphs;
import java.util.ArrayList;
import java.util.List;
// Cycle detection directed graph
public class SafeStates {
    
}
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> arr= new ArrayList<>();
        int num=graph.length;
        boolean rs[]= new boolean [num];
        for(int i=0;i<num;i++){
            if(!rs[i]){     
            boolean vis[]= new boolean [num];
                safe(graph,vis,rs,i);
            }
        }
        for(int i=0;i<num;i++){
            if(!rs[i]){
                arr.add(i);
            }
        }
        return arr;
    }
    private void safe(int [][]graph, boolean vis[],boolean rs[],int curr){
        if(vis[curr]||rs[curr]){
            return;
        }
        vis[curr]=true;
        rs[curr]=true;
        for(int i=0;i<graph[curr].length;i++){
            safe(graph,vis,rs,graph[curr][i]);
            if(rs[graph[curr][i]]){
                return;
            }
        }
        rs[curr]=false;
        return;
    }
}