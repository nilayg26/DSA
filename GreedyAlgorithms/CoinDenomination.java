package GreedyAlgorithms;

import java.util.Arrays;

public class CoinDenomination {
    public static void main(String[] args) {
        
    // int[] coins = {1, 3, 4, 5};
    //     int sum = 7;
        int[] coins = {25,10,5};
        int sum = 30;
    int [][]dp= new int [coins.length][sum];
    for(int i=1;i<=sum;i++){
        if(coins[0]>i){
            dp[0][i-1]=Integer.MAX_VALUE;
        }
        else{
            int q = i/coins[0];
            if(i%coins[0]!=0){
               dp[0][i-1]=Integer.MAX_VALUE;
            }
            else{
                dp[0][i-1]=q;
            }
        }
    }
    System.out.println(Arrays.deepToString(dp));
    for(int i=1;i<coins.length;i++){
        for(int j=2;j<=sum;j++){
            int q= j/coins[i];
            if(q!=0){
                int diff= j-(coins[i]*q);
                if(diff==0){
                    dp[i][j-1]= Math.min(dp[i-1][j-1],q);
                }
                else{
                    if(dp[i-1][diff-1]==Integer.MAX_VALUE){
                        dp[i][j-1]= dp[i-1][j-1];
                    }
                    else{
                        dp[i][j-1]= Math.min(dp[i-1][j-1], dp[i-1][diff-1]+q);
                    }
                }
            }
            else{
                dp[i][j-1]=dp[i-1][j-1];
            }
        }
    }
    System.out.println(Arrays.deepToString(dp));
    int res= sum==0 ? 0: dp[coins.length-1][sum-1];
    System.out.println(res);
}
}
