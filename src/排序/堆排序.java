package 排序;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heap(arr);
        System.out.println(Arrays.toString(arr));
        //堆排序的本质
        //1、构建出一个最大二叉堆（以数组的形式去存储树）
        //2、再将每个堆顶元素与数组倒数的元素交换，这样从后往前就依次是堆顶的最大元素
    }


    public static void heap(int[] arr) {

        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downJust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downJust(arr, 0, i);
        }
    }


    public static void downJust(int[] arr, int parentIndex, int length) {
        int childIndex = parentIndex * 2 + 1;
        int temp = arr[parentIndex];

        while (childIndex < length) {
            if (childIndex + 1 < length && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++;
            }

            if (temp > arr[childIndex]) {
                break;
            }

            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }

        arr[parentIndex] = temp;
    }


}
