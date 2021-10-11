package 排序算法;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arrays = {2, 4, 0, 8, 1, 5, 7};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
        int[] array2 = {9,2, 4, 0, 8, 1, 5, 7};
        sortOptimize(array2);
        System.out.println(Arrays.toString(array2));
    }


    //相邻两个元素比较
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //优化

    public static void sortOptimize(int[] array) {
        int lastSortIndex = 0;
        int boradIndex;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = false;
                    lastSortIndex = j;
                }
                boradIndex=lastSortIndex;
            }
            if (isSort){
                break;
            }
        }
    }

}
