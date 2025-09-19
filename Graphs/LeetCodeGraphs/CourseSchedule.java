package JAVA_DSA.Graphs.LeetCodeGraphs;

import java.util.ArrayList;
import java.util.HashMap;
// https://leetcode.com/problems/course-schedule/description/
// Cycle detection directed graph
public class CourseSchedule {
    
}
class Solution {
    int num;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        num=prerequisites.length;
        boolean []vis= new boolean [numCourses];
        boolean []rs=new boolean [numCourses];
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<num;i++){
            if(!map.containsKey(prerequisites[i][1])){
                ArrayList<Integer> arr= new ArrayList<>();
                arr.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],arr);
            }
            else{
                ArrayList<Integer> arr= map.get(prerequisites[i][1]);
                arr.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],arr);
            }
        }
        if(num>0){
        for(int i=0;i<numCourses;i++){
            if(!vis[i]&&i<num){
            if(isCycle(prerequisites[i][1],vis,rs,map)){
             return false;
           }
        }
        }
        }
        return true;
    }
    boolean isCycle(int curr,boolean []vis,boolean[]rs,HashMap<Integer, ArrayList<Integer>>map) {
        if(vis[curr]){
            return false;
        }
        else{
            vis[curr]=true;
            rs[curr]=true;
            if(map.containsKey(curr)){
            ArrayList<Integer>arr= map.get(curr);
            int size=arr.size();
            for(int i=0;i<size;i++){
                boolean res= isCycle(arr.get(i),vis,rs,map);
                if(rs[arr.get(i)]){
                    return true;
                }
                if(res){
                    return true;
                }
            }
            }
            rs[curr]=false;
            return false;
        }
    }
}