package GreedyAlgorithms;

import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
public class Trains {
    class Solution {
    static class Train implements Comparable<Train>{
        int arr;
        int dep;
        Train(int a, int d){
            this.arr=a;
            this.dep=d;
        }
        @Override
        public int compareTo(Train t1){
            return this.arr-t1.arr;
        }
        
    }
    static int findPlatform(int arr[], int dep[]) {
        int n= arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
      int maxPlatform=0;
      int platform=0;
      int i=0,j=0;
      while(i< n && j < n){
          if(arr[i]<=dep[j]){
              platform++;
              maxPlatform= Math.max(platform,maxPlatform);
              i++;
          }
          else{
              platform--;
              j++;
          }
      }
      return maxPlatform;
    }
}

}
