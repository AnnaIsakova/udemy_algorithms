package soting_and_searching;

import java.util.Arrays;

import static soting_and_searching.Helper.swap;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {4, 5, 7, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

}
