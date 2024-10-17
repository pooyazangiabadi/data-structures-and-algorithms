package sorting.counting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 8, 17, 11};
        System.out.println(Arrays.toString(selectionSort(arr)));

    }

    private static int[] selectionSort(int[] inputArr) {
        int indexItem;
        int swapItem;
        for (int i = 0; i < inputArr.length - 1; i++) {
            indexItem = i;
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[j] < inputArr[indexItem]) {
                    indexItem = j;
                }
            }
            swapItem = inputArr[i];
            inputArr[i] = inputArr[indexItem];
            inputArr[indexItem] = swapItem;
        }
        return inputArr;
    }
}
