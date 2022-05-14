package heap;

public class MinHeap {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(5);
        System.out.println(heap.getMin());
        heap.popMin();
        System.out.println(heap.getMin());
        heap.insert(-1);
        System.out.println(heap.getMin());
        heap.popMin();
        heap.popMin();
        heap.popMin();
        heap.popMin();
        heap.popMin();
        heap.popMin();
        heap.popMin();
        System.out.println(heap.getMin());
    }
}

class Heap {
    int size;
    int capacity;
    int arr[];

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    public void insert(int val) {
        if(size >= capacity)    return;
        arr[size] = val;
        int curr = size;
        while(curr != 0) {
            if(arr[curr] < arr[(curr-1)/2]) {
                int temp = arr[curr];
                arr[curr] = arr[(curr-1)/2];
                arr[(curr-1)/2] = temp;
                curr = (curr-1)/2;
            } else {
                break;
            }
        }
        size++;
    }

    public int getMin() {
        if(size == 0)   return Integer.MIN_VALUE;
        return arr[0];
    }

    public int popMin() {
        if(size == 0)   return Integer.MIN_VALUE;
        int retValue = arr[0];
        arr[0] = arr[size-1];
        size--;
        int curr = 0;
        while(curr < size) {
            int left = curr*2+1 < size ? curr*2+1 : -1;
            int right = curr*2+2 < size ? curr*2+2 : -1;
            int minIndex = curr;

            if(left != -1 && (arr[left] < arr[minIndex])) {
                minIndex = left;
            }
            if(right != -1 && (arr[right] < arr[minIndex])) {
                minIndex = right;
            }

            if(minIndex == curr)
                break;
            int temp = arr[curr];
            arr[curr] = arr[minIndex];
            arr[minIndex] = temp;
            curr = minIndex;
        }
        return retValue;
    }
}