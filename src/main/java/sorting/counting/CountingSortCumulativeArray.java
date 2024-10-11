package sorting.counting;

import java.util.Arrays;

public class CountingSortCumulativeArray {
    public static void main(String[] args) {
        int[] sorted=countingSort(new int[]{3,2,1,1,1,3,2,2});
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] countingSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();

        int[] countingArray = new int[max+1];

        for (int i : arr) {
            countingArray[i] +=1;
        }

        int[] outputArray=new int[arr.length];

        for (int i = 1; i <= max; i++) {
            countingArray[i] += countingArray[i - 1];
        }


        for (int i = arr.length - 1; i >= 0; i--) {
            outputArray[countingArray[arr[i]] - 1] = arr[i];
            countingArray[arr[i]]--;
        }

        return outputArray;
    }
}
