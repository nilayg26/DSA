package JAVA_DSA.Sorting;

import java.util.Arrays;
import java.util.Scanner;

//In Merge Sort for every Conquer we need to create a new Array which requires memeory But worst case time complexity is O(nlogn)
//In Quick Sort no new Array is created but Worst Case time complexity is O(n^2) in Quick sort
public class AdvanceSortings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MergeSort m = new MergeSort(arr);
        m.sortArray();
        System.out.println(Arrays.toString(arr));
        QuickSort q = new QuickSort(arr);
        q.sortArray();
        System.out.println(Arrays.toString(arr));
    }
}

class MergeSort { // for worst case: O(nlogn)
    // divide and conquer technique
    private int[] arr;
    private int size;
    MergeSort(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }
    void sortArray() {
        divide(0, size - 1);
    }
    private void divide(int s, int e) {// logn time
        if (e == s) {
            return;
        } else {
            int mid = (s + e) / 2; // or int mid= (s)+(e-s)/2;
            divide(s, mid);
            divide(mid + 1, e);
            conquer(s, mid, e);
        }
    }

    private void conquer(int s, int mid, int e) { // O(n) time
        int i = s;
        int j = mid + 1;
        int[] sortedArray = new int[e - s + 1];
        int k = 0;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                sortedArray[k++] = arr[i++];
            } else {
                sortedArray[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            sortedArray[k++] = arr[i++];
        }
        while (j <= e) {
            sortedArray[k++] = arr[j++];
        }
        for (int t = 0; t < sortedArray.length; t++) {
            arr[s + t] = sortedArray[t];
        }
        return;
    }
}

class QuickSort {
    private int[] arr;
    private int size;
    QuickSort(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }
    private int partition(int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }
    private void qSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int piIdx = partition(low, high);
        qSort(low, piIdx - 1);
        qSort(piIdx + 1, high);
    }
    void sortArray() {
        qSort(0, size - 1);
    }
}
