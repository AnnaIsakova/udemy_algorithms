package soting_and_searching;

import java.util.Arrays;

import static soting_and_searching.Helper.swap;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8,5,2,6,3,9,4,1,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        int increment = arr.length / 2;
        while (increment >= 1){
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSortForShellSort(arr, startIndex, increment);
            }
            increment /= 2;
        }
    }

    static void insertionSortForShellSort(int[] arr, int startIndex, int increment){
        for (int i = startIndex; i < arr.length; i += increment) {
            for (int j = Math.min(i+increment, arr.length-1);
                 j - increment >= 0;
                 j -= increment) {
                if (arr[j-increment] > arr[j]){
                    swap(arr, j, (j-increment));
                } else break;
            }
        }
    }
}
