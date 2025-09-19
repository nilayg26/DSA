package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class JobScheduling  {
    static class Job implements Comparable<Job>{
        int id;
        int deadline;
        int profit;
        Job(int i, int d, int p){
            this.id=i;
            this.deadline=d;
            this.profit=p;
        }
        @Override
        public int compareTo(Job j1){
            return j1.profit-this.profit;
        }
        @Override
        public String toString(){
            return "id= "+id+" deadline="+deadline+" profit="+profit;
        }
    }
    public static void main(String[] args) {
        System.out.println("Hellooooo");
        int []id= {1, 2, 3, 4, 5};
        int []deadline={2, 1, 2, 1, 1};
        int []profit={100, 19, 27, 25, 15};
        System.out.println(JobSequencing(id, deadline, profit));
    }
    public static ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int size= id.length;
        PriorityQueue <Job> q= new PriorityQueue<>();
        for(int i=0;i<size;i++){
            q.add(new Job(id[i],deadline[i],profit[i]));
        }
        System.out.println(q);
        boolean [] dp= new boolean[size];
        ArrayList<Integer> result= new ArrayList<>();
        int count =0;
        int pro =0;
        for(int i=0;i<size;i++){
          Job curr= q.remove();
          if(dp[curr.deadline-1]){
              int j=curr.deadline-1;
              while(j>=0){
                  if(!dp[j]){
                      dp[j]=true;
                      count++;
                      pro+=curr.profit;
                      break;
                  }
                  j--;
              }
          }
          else{
              dp[curr.deadline-1]=true;
              count++;
              pro+=curr.profit;
          }
        }
        result.add(count);
        result.add(pro);
        return result;
    }
}
