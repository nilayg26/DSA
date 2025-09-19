package JavaPractise;
import java.util.Scanner;

public class GoodSubarray {
    static int []list;
    static int n;
    static int k;
    static int []count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n];
        count= new int [1000000];
        int [][]dp = new int[n][n];
        k=sc.nextInt();
        int dis=0;
        for(int i=0;i<n;i++){
            list[i]=sc.nextInt();
            if(count[list[i]]==0){
                dis++;
            }
            count[list[i]]++;
        }
        if(dis<k){
            System.out.println(-1);
        }
        else{
            System.out.println(goodSubarray(0, n-1, dis,dp));
        }
    }
    private static int goodSubarray(int i,int j,int currdis,int [][]dp){
        if(i>j || currdis<k){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int currlen= j-i+1;
        int dis = currdis;
        count[list[i]]--;
        if(count[list[i]]==0){
            dis--;
        }
        int left = goodSubarray(i+1, j,dis,dp);
        count[list[i]]++;
        count[list[j]]--;
        dis=currdis;
        if(count[list[j]]==0){
            dis--;
        }
        int right = goodSubarray(i, j-1,dis,dp);
        count[list[j]]++;
        return dp[i][j]=Math.min(currlen,Math.min(left, right));
    }
}
