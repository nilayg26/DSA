
package JAVA_DSA.ReccursionBacktrack;
//This program calculates total number of different paths from which a user can travel from
// (0,0)th to (n-1,m-1)th coordinate in a n*m matrix; n= no. of rows m= no. of columns; You can
// travel either right or downward at a time
import java.util.Scanner;
public class total_no_path_in_maze {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc1.nextInt(); //no.rows
        System.out.println("Enter number of coloumns: ");
        int m = sc2.nextInt(); //no. coloumns
        travelling(n, m, 0, 0);
        System.out.println(count);
    }

    public static void travelling(int n, int m, int row, int column) {
        int col = column;
        if (row == n - 1) {

            if (row == (n - 1) && col == (m - 1)) {
                count = count + 1;
                return;
            }
            travelling(n, m, row, col + 1);

        } else {
            for (col = column; col < m; col++) {
                travelling(n, m, row + 1, col);
            }
        }

    }
}
