import java.util.*;
public class LCS {
    static int n = 7;
    static int m = 4;
    public static void main(String[] args) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        String x = "xdyabcf";
        String y = "dabc";
        System.out.println(lcs(x, y, 0, 0, dp));
    }
    private static int lcs(String x, String y, int i, int j, int[][] dp) {
        if (i > n - 1 || j > m - 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else {
            if (x.charAt(i) == y.charAt(j)) {
                return dp[i][j] = 1 + lcs(x, y, i + 1, j + 1, dp);
            } else {
                return dp[i][j] = Math.max(lcs(x, y, i + 1, j, dp), lcs(x, y, i, j + 1, dp));
            }
        }
    }
}