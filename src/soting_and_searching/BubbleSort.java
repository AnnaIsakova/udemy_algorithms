package soting_and_searching;

import java.util.Arrays;

import static soting_and_searching.Helper.swap;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {1, 4, 7, 2, 5, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean swapsMade = false;
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]){
//                    System.out.println(arr[j]);
//                    System.out.println(arr[j+1]);
                    swap(arr, j, (j+1));
                    swapsMade = true;
//                    System.out.println(Arrays.toString(arr));
                }
            }
            if (!swapsMade) break;
        }
    }
}
