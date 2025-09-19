//https://codeforces.com/contest/2049/problem/B
package JAVA_DSA.CodeForcesImpt;
import java.util.Scanner;
public class q1{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
        int n=sc.nextInt();
        int arr[]=new int[n];
        char []ch=sc.next().toCharArray();
        boolean occ[]=new boolean[n];
        if(getComb(arr, ch, occ, 0)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        }
    }
    private static boolean getComb(int []arr,char []ch,boolean[]occ,int curr){
        if(curr==ch.length){
            return true;
        }
        for(int i=0;i<arr.length;i++){
            if(!occ[i]){
            if(ch[curr]=='p'){
                occ[i]=true;
                if(checkP(curr,occ)){
                    if(getComb(arr, ch, occ, curr+1)){
                        return true;
                    }
                }
                else{
                    occ[i]=false;
                    return false;
                }
            }
            else if(ch[curr]=='s'){
                if(checkS(curr,occ)){
                    occ[i]=true;
                    if(getComb(arr, ch, occ, curr+1)){
                        return true;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                occ[i]=true;
                if(getComb(arr, ch, occ, curr+1)){
                    return true;
                }
            }
            occ[i]=false;
        }
        } 
        return false;
    }
    private static boolean checkP(int curr,boolean[]occ){
        for(int i=0;i<=curr;i++){
            if(!occ[i]){
                return false;
            }
        }
        return true;
    }
    private static boolean checkS(int curr,boolean[]occ){
        for(int i=curr;i<occ.length;i++){
            if(occ[i-curr]){
                return false;
            }
        }
        return true;
    }
}