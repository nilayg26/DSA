package JAVA_DSA.ReccursionBacktrack;
//This Programme calculates total no. of tiles of size (1xM) that can be placed in a matrix of order NxM
// For reccursive functions, most important part is a base case 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tile {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = s1.nextInt(); // no. of rows
        System.out.println("Enter number of coloumns: ");
        int m = s1.nextInt(); // no. of coloumns
        System.out.println("Output is: "+travelling(n, m));
    }

    public static int travelling(int n, int m) {
        if (n < m) {
            return 1;
        } else if (n == m) {
            return 2;
        }
        int placing_vertical = travelling(n-m, m);
        int placing_horizontal = travelling(n - 1, m);
        return (placing_horizontal + placing_vertical);
    }
}