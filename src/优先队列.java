import java.awt.event.TextEvent;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 优先队列 {
    public static void main(String[] args) {
        PriorityQueue2 priorityQueue = new PriorityQueue2();
        priorityQueue.enQueue(3);
    }


}

class PriorityQueue2 {
    private int[] array;
    private int size;

    public PriorityQueue2() {
        array = new int[32];
    }

    public void enQueue(int key) {
        if (size >= array.length) {
            reSize();
        }
        upAdjust();
    }

    public void upAdjust() {
        //最大优先队列
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    public void reSize() {
        int newSize = 2 * size;
        this.array = Arrays.copyOf(this.array, newSize);
    }
}
