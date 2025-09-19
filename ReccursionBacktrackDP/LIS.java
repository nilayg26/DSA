package ReccursionBacktrackDP;

import java.util.Arrays;
import java.util.Scanner;

//Longest increasing Subsequence
public class LIS {
    static int []nums;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n= 11;
        int[] input = {5, 6, 2, 3, 4, 1, 9, 9, 8, 9, 5};
        nums= new int[11];
        for(int i=0;i<n;i++){
            nums[i]=input[i];
        }
        int []dp= new int[n];
        Arrays.fill(dp, -1);
        backtrack(0, dp);
        int max=0;
        for(int i: dp){
            if (max<i) {
                max=i;
            }
        }
        System.out.println(max);
        System.out.println(Arrays.toString(dp));
    }
    private static int backtrack(int curr,int []dp){
        if(dp[curr]!=-1){
            return dp[curr];
        }
        int len=1;
        int maxLen=1;
        for(int i=curr+1;i<n;i++){
            len =1;
            if (nums[curr]<nums[i]) {
                len = backtrack(i,dp)+1;
                if(len>maxLen){
                    maxLen=len;
                }
            }
            else{
                backtrack(i, dp);
            }
        }
        return dp[curr]=maxLen;
    }
}
