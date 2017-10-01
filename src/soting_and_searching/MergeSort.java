package soting_and_searching;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 2, 1, 6, 0, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        if (arr.length == 1) return;

        int middle = (arr.length/2) + (arr.length % 2);
        int[] firstArr = new int[middle];
        int[] secondArr = new int[arr.length - middle];

        split(arr, firstArr, secondArr);
        sort(firstArr);
        sort(secondArr);
        merge(arr, firstArr, secondArr);
    }

    private static void split(int[] arrToSplit, int[] firstArr, int[] secondArr){
//        System.out.println(Arrays.toString(arrToSplit));
        int middle = firstArr.length;
        for (int i = 0; i < arrToSplit.length; i++) {
            if (i < middle){
                firstArr[i] = arrToSplit[i];
            } else {
                secondArr[i-middle] = arrToSplit[i];
            }
        }
//        System.out.println("first:  " + Arrays.toString(firstArr));
//        System.out.println("second: " + Arrays.toString(secondArr));
    }

    private static void merge(int[] arrToSort, int[] firstArr, int[] secondArr){
        int firstIndex = 0;
        int secondIndex = 0;
        int mergeIndex = 0;

        while (firstIndex < firstArr.length && secondIndex < secondArr.length){
            if (firstArr[firstIndex] < secondArr[secondIndex]){
                arrToSort[mergeIndex] = firstArr[firstIndex];
                firstIndex++;
            } else {
                arrToSort[mergeIndex] = secondArr[secondIndex];
                secondIndex++;
            }
            mergeIndex++;
        }

        if (firstIndex < firstArr.length){
            while (mergeIndex < arrToSort.length){
                arrToSort[mergeIndex] = firstArr[firstIndex];
                firstIndex++;
                mergeIndex++;
            }
        }
        if (secondIndex < secondArr.length){
            while (mergeIndex < arrToSort.length){
                arrToSort[mergeIndex] = secondArr[secondIndex];
                secondIndex++;
                mergeIndex++;
            }
        }
    }
}
