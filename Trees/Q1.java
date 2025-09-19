import java.util.*;
/*
 * Here is the extracted text from the image:

---
**3. Best Sum Downward Tree Path**  

Given a tree with \( n \) nodes, rooted at node 0 (nodes are numbered from 0 to \( n-1 \)), with values assigned to nodes such that `values[i]` denotes the value of node \( i \), find the maximal sum of values along any path starting at some node \( u \) and going only down the tree. In other words, only consider paths \( u_1, u_2, u_3, \dots, u_k \) where each node \( u_i \) is a child of node \( u_{i-1} \) for \( 1 \leq i \leq k \).  

For example, given the following tree (labeled node number / value):  

```
     0/5
    /   \
  1/7   2/-10
  /        \
4/15       3/4
```

Two possible paths are:  
- \( 0 \to 1 \to 2 \to 3 \) with a sum of \( 5 + 7 + (-10) + 4 = 6 \).  
- \( 1 \to 2 \to 3 \) with a sum of \( 7 + (-10) + 4 = 1 \).  
- The highest sum path is \( 0 \to 4 \) with a sum of \( 5 + 15 = 20 \).  

---
 */

import java.util.Scanner;

public class Q1{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
    }
}
class Solution {
    public static List<List<Integer>> getFinalImage(List<List<Integer>> image, int rotation, int vertical_flip, int horizontal_flip) {
        int n = image.size();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = image.get(i).get(j);
            }
        }
        
        int[][] rotated = new int[n][n];
        switch (rotation) {
            case 90:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        rotated[j][n - 1 - i] = matrix[i][j];
                    }
                }
                break;
            case 180:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        rotated[n - 1 - i][n - 1 - j] = matrix[i][j];
                    }
                }
                break;
            case 270:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        rotated[n - 1 - j][i] = matrix[i][j];
                    }
                }
                break;
            default:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        rotated[i][j] = matrix[i][j];
                    }
                }
        }
        
        int[][] afterVerticalFlip = new int[n][n];
        if (vertical_flip == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    afterVerticalFlip[n - 1 - i][j] = rotated[i][j];
                }
            }
        } else {
            afterVerticalFlip = rotated;
        }
        
        int[][] finalMatrix = new int[n][n];
        if (horizontal_flip == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    finalMatrix[i][n - 1 - j] = afterVerticalFlip[i][j];
                }
            }
        } else {
            finalMatrix = afterVerticalFlip;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(finalMatrix[i][j]);
            }
            result.add(row);
        }
        
        return result;
    }
}