package JAVA_DSA.ReccursionBacktrack;
import java.util.Scanner;
public class fibonacci_recursion {
    static int n;
    public static void main(String [] args) {
        System.out.println("Enter number of n: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
        } else if (n == 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
            System.out.println(1);
            fr(1, 0, 1, 0);
        }
    }
        public static void fr(int x,int  a,int  b, int s) {
            if (x <= n - 2) {
                s = a + b;
                a = b;
                b = s;
                System.out.println(s);
                fr((x + 1), a, b, s);
            } else {
                System.out.println("Execution finished ");
            }

        }

        }



