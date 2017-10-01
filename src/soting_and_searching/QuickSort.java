package soting_and_searching;

import java.util.Arrays;

import static soting_and_searching.Helper.swap;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 5, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int lo, int hi){
        if (lo >= hi) return;

        int pivotIndex = partition(arr, lo, hi);
        quickSort(arr, lo, pivotIndex);
        quickSort(arr, (pivotIndex+1), hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int l = lo;
        int h = hi;
        while (l < h){
            while (arr[l] <= pivot && l < h){
                l++;
            }
            while (arr[h] > pivot){
                h--;
            }
            if (l < h){
                swap(arr, l, h);
            }
        }
        swap(arr, lo, h);
        return h;
    }
}
