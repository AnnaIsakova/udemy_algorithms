package soting_and_searching;

import java.util.Arrays;

import static soting_and_searching.Helper.swap;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,1,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j-1] > arr[j]){
                    swap(arr, j, (j-1));
                } else break;
            }
        }
    }
}
