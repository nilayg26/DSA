import java.util.Arrays;

public class CoinDenomination {
    public static void main(String[] args) {
        int[] coins = {1, 3, 4, 5};
        int sum = 7;
        int[][] dp = new int[coins.length][sum+1];
        // initialising base values
        for(int i=0;i< sum+1 ;i++){
            if(coins[0]>i){
                dp[0][i]=0;
            }
            else{
                int q= i/coins[0];
                if(q==0){
                    dp[0][i]=0;
                }
                else{
                    dp[0][i]=q*coins[0];
                }
            }
        }
        //bottom up approach
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int val = j/coins[i];
                dp[i][j] = check(val, dp, j, i,coins[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println("Min no of coin is "+dp[coins.length-1][sum]);
    }

    private static int check(int q, int[][] dp, int j,int i,int coin) {
        if(q!=0){
            int cal= coin*q;
            int diff= dp[i-1][j-cal];
            if(q + diff < dp[i-1][j]){
                return  q + diff;
            }
        }
        return dp[i-1][j];
    }
}
