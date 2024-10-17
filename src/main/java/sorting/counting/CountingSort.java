package sorting.counting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] sorted=countingSort(new int[]{3,2,1,1,1,3,2,2});
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        int[] countingArray = new int[max+1];

        for (int i : arr) {
            countingArray[i] +=1;
        }

        int[] outputArray=new int[arr.length];

        int index=0;
        for (int i = 0; i < max+1; i++) {
            for (int j=0;j < countingArray[i]; j++){
                outputArray[index]=i;
                index++;
            }
        }

        return outputArray;
    }
}
