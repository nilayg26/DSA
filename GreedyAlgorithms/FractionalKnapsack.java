package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FractionalKnapsack {
    class Solution {
    static class Item implements Comparable<Item>{
        double dens;
        double wt;
        Item(double d, double w){
            this.dens= d;
            this.wt=w;
        }
        @Override
        public int compareTo(Item t1){
            return Double.compare(t1.dens, this.dens);
        }
    }
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        PriorityQueue<Item> q= new PriorityQueue<>();
        for(int i=0;i<val.size();i++){
            q.add(new Item(((double)val.get(i)/wt.get(i)),wt.get(i)));
        }
        
        double curr_capacity=0;
        double profit=0;
        while(!q.isEmpty()){
            Item curr = q.remove();
            double diff= capacity-curr_capacity;
            if(diff>=curr.wt){
                curr_capacity+=curr.wt;
                profit+=curr.dens*curr.wt;
            }
            else if(diff>0){
                profit+=curr.dens*(diff);
                return roundVal(profit);
            }
        }
        return roundVal(profit);
    }
    private double roundVal(double val){
        double rounded = Math.round(val* 1_000_000.0) / 1_000_000.0;
        return rounded;
    }
}
}
