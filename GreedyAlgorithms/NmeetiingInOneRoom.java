package GreedyAlgorithms;

import java.util.PriorityQueue;

public class NmeetiingInOneRoom {
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        Meeting(int s, int e){
            this.start=s;
            this.end=e;
        }
        @Override
        public int compareTo(Meeting m2){
            return this.end-m2.end;
        }
    }
    public static void main(String[] args) {
        
    }
    public static int maxMeetings(int start[], int end[]) {
        int count=1;
        PriorityQueue<Meeting> q= new PriorityQueue<>();
        int size= start.length;
        for(int i=0;i<size;i++){
            q.add(new Meeting(start[i],end[i]));
        }
        Meeting curr= q.remove();
        for(int i=0;i<size && !q.isEmpty();i++){
                Meeting itr= q.remove();
                if(curr.end<itr.start){
                    curr=itr;
                    count++;
                }
        }
        return count;
    }
}
