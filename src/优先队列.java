import java.awt.event.TextEvent;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 优先队列 {
    public static void main(String[] args) {
        PriorityQueue2 priorityQueue = new PriorityQueue2();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("最大优先队列=="+priorityQueue.deQueue());
        System.out.println("最大优先队列=="+priorityQueue.deQueue());
        System.out.println("最大优先队列=="+priorityQueue.deQueue());
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
        array[size++] = key;
        upAdjust();
    }

    public int deQueue() {
        if (size < 0) {
            throw new IndexOutOfBoundsException("");
        }
        int heap = array[0];
        array[0] = array[--size];
        downAdjust();
        return heap;

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

    public void downAdjust() {
        int parentIndex = 0;
        int childIndex = 1;
        int temp = array[0];
        while (childIndex < size) {
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp > array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex *2 + 1;
        }

        array[parentIndex] = temp;
    }

    public void reSize() {
        int newSize = this.size*2;
        this.array = Arrays.copyOf(this.array, newSize);
    }
}
