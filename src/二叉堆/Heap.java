package 二叉堆;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] arrays = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 0};
        System.out.println(Arrays.toString(arrays));
        UpAdjust(arrays);
        System.out.println(Arrays.toString(arrays));
        int[] arrays2 = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        System.out.println(Arrays.toString(arrays2));
        heap(arrays2);
        System.out.println(Arrays.toString(arrays2));
    }

    public static void heap(int[] arrays2) {
        for (int i = (arrays2.length - 2) / 2; i >= 0; i--) {
            DownAdjust(arrays2, i, arrays2.length);
        }
    }

    public static void UpAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex-1) / 2;

        int temp = array[childIndex];

        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    public static void DownAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            if (temp < array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }
}
