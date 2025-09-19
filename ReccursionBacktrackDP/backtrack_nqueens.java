// package JAVA_DSA.ReccursionBacktrack;
//The N Queen is the problem of placing N chess queens on an N×N chessboard 
//so that no two queens attack each other.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class backtrack_nqueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 4) {
            System.out.println("No possible solution");
        } else {
            List<List<String>> allboard = new ArrayList<>();
            char[][] boards = new char[n][n];
            helper( allboard, boards,0);
            System.out.println(allboard);

        }
    }

    public static void helper(List<List<String>> allboard, char[][] boards, int col) {
        int row;
        if (col == boards.length) {
            boardsave(boards, allboard);
            return;
        }
        for (row = 0; row < boards.length; row++) {
            if (qsafe(col, boards, row)) {
                boards[row][col] = 'Q';
                helper(allboard, boards, col + 1);
                boards[row][col] = '.';
            }

        }

    }

    public static boolean qsafe(int col, char[][] boards, int row) {
        int r = 0;
        int c = 0;

        for (r = 0; r < boards.length; r++) { //vertical
            if (boards[r][col] == 'Q') {
                return false;
            }
        }
        for (c = 0; c < boards.length; c++) { //horizontal
            if (boards[row][c] == 'Q') {
                return false;
            }
        }
        for (c = col, r = row; c >= 0 && r < boards.length; c--, r++) { //left downward
            if (boards[r][c] == 'Q') {
                return false;
            }
        }
        for (c = col, r = row; c < boards.length && r < boards.length; c++, r++) { //right downward
            if (boards[r][c] == 'Q') {
                return false;

            }
        }
        for (c = col, r = row; c < boards.length && r >= 0; c++, r--) {//right upward
            if (boards[r][c] == 'Q') {
                return false;
            }
        }
        for (c = col, r = row; c >= 0 && r >= 0; c--, r--) {//left upward
            if (boards[r][c] == 'Q') {
                return false;

            }
        }
        return true;

    }
    public static void boardsave(char [][] boards, List<List<String>> allboard){
        int r=0; int c=0;
        List<String> boardSave= new ArrayList<>();
        for(r=0; r< boards.length; r++){
            String save="";
            for(c=0; c< boards.length; c++){
                if(boards[r][c]=='Q'){
                   save= save+"Q";
                }
                else{
                    save =save+".";
                }}
            boardSave.add(save);
        }
        allboard.add(boardSave);

        }

    }







