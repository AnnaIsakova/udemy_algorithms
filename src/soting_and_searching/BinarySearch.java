package soting_and_searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,45,23,17,8,9,10};
        int index = search(arr, 7);
        System.out.println(index);
    }

    private static int search(int[] arr, int num) {
        int middle = 0;
        int hi = arr.length - 1;
        int lo = 0;

        while (lo <= hi){
            middle =  (hi + lo) / 2;
            if (arr[middle] == num){
                return middle;
            } else if (arr[middle] > num){
                hi = middle - 1;
            } else {
              lo = middle + 1;
            }
        }

        return -1;
    }
}
