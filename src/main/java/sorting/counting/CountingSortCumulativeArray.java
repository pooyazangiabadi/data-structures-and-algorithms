package sorting.counting;

import java.util.Arrays;
import java.util.HashSet;

public class CountingSortCumulativeArray {
    public static void main(String[] args) {
        String chars=countSortString("zkwvz");
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

        for (int i = 1; i <= max; i++) {
            countingArray[i] += countingArray[i - 1];
        }


        for (int i = arr.length - 1; i >= 0; i--) {
            outputArray[countingArray[arr[i]] - 1] = arr[i];
            countingArray[arr[i]]--;
        }

        return outputArray;
    }

    static char[] countSort(char arr[]) {

        //Your code here
        int min=arr[0];
        int max=arr[0];
        for (char item:arr){
            if(item>max) max=item;
            if(item<min) min=item;
        }

        int count=max-min+1;
        int[] countingArray=new int[max-min+1];

        for (int i=0;i<arr.length;i++) {
            countingArray[arr[i]-min]++;
        }

        char[] outputArray=new char[arr.length];

        int index=0;
        for (int i = 0; i < count; i++) {
            for (int j=0;j < countingArray[i]; j++) {
                outputArray[index]= (char) (i+min);
                index++;
            }
        }

        return outputArray;

    }

    static String countSortString(String arr) {

        //Your code here
        char[] array=arr.toCharArray();
        int min=array[0];
        int max=array[0];
        for (char item:array){
            if(item>max) max=item;
            if(item<min) min=item;
        }

        int count=max-min+1;
        int[] countingArray=new int[max-min+1];

        for (int i=0;i<array.length;i++){
            countingArray[array[i]-min]++;
        }

        StringBuilder outputArray=new StringBuilder();

        int index=0;
        for (int i = 0; i < count; i++) {
            for (int j=0;j < countingArray[i]; j++){
                outputArray.append((char) (i+min));
                index++;
            }
        }

        return outputArray.toString();

    }
}
