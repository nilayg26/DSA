import java.util.Arrays;


public class LeetCode1718{
    public static void main(String[] args) {
        Solution s = new Solution();
        for(int i=2;i<=20;i++){
        System.out.println(i+" "+Arrays.toString(s.constructDistancedSequence(i)));
        }
    }
}
class Solution {
    int size;
    int n;
    int[] finalR;
    int value;
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[(2 * n) - 1];
        this.n = n;
        size = (2 * n) - 1;
        Arrays.fill(result, -1);
        result[0] = n;
        result[n] = n;
        boolean isPresent[] = new boolean[n + 1];
        isPresent[n] = true;
        lexSeq(1, isPresent, result, 1);
        return result;
    }
    private boolean lexSeq(int curr, boolean isPresent[], int[] result, int count) {
        if (curr == size) {
            return false;
        }
        for (int i = n - 1; i >= 1; i--) {
            if (i != n - 2) {
                if (!isPresent[i] && (i == 1 && curr < size || curr + i < size)) {
                    int otherIndex = (i == 1) ? curr : curr + i;
                    if ( (result[curr] == 0 || !isPresent[result[curr]]) && (i == 1 || result[otherIndex] == 0 || !isPresent[result[otherIndex]])) {
                        result[curr] = i;
                        if (i != 1)
                            result[otherIndex] = i;
                        isPresent[i] = true;
                        count++;
                        if (count == n) {
                            return true;
                        }
                        if (lexSeq(curr + 1, isPresent, result, count)) {
                            return true;
                        }
                        isPresent[i] = false;
                        count--;
                        result[curr] = result[otherIndex] = 0;
                    } else {
                        if (result[curr] == 0) {
                            continue;
                        }
                        if (lexSeq(curr + 1, isPresent, result, count)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}