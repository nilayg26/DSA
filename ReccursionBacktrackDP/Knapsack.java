import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {
    static int maxWt = 7;

    public static void main(String[] args) {
        int[][] values = {
                { 0, 0 },
                { 2, 3 }, // v1, w1
                { 2, 1 }, // v2, w2
                { 4, 3 }, // v3, w3
                { 5, 4 }, // v4, w4
                { 3, 2 }  // v5, w5
        };
        int[][] dp = new int[values.length][maxWt + 1];
        // initialising sub cases
        for (int i = 0; i < maxWt + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < values.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < maxWt + 1; j++) {
                dp[i][j] = check(values[i], i, j, dp);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println("Max val: " + dp[values.length-1][maxWt]);
        System.out.println("Included weights :"+getContents(dp, values));
    }
    private static ArrayList<Integer> getContents(int[][]dp, int [][]values){
        ArrayList<Integer> arr= new ArrayList<>();
        int i = dp.length-1;
        int j= dp[0].length-1;
        int curr= dp[i][j];
        while(i>=1){
            if(curr!=dp[i-1][j]){
                System.out.println(Arrays.toString(values[i]));
                arr.add(values[i][1]);
                j=j-values[i][1];
                curr=dp[i-1][j];
            }
            i--;
        }
        return arr;
    }
    private static int check(int[] is, int i, int j, int[][] dp) {
        int curr_val = is[0];
        int curr_wt = is[1];
        if (curr_wt > j) {
            return dp[i - 1][j];
        } else {
            int r_wt = j - curr_wt;
            int idx = dp[i - 1][r_wt];
            
            if (idx + curr_val > dp[i - 1][j]) {
                return idx+curr_val ;
            }
        }
        return dp[i - 1][j];
    }

}
