package lesson6;

public class MyHeap {
    private int heapSize;

    public void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a,0,heapSize-1);
            heapSize--;
            heapify(a,0);
        }
    }

    private void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length/2; i >= 0; i--) {
            heapify(a,i);
        }
    }

    private void heapify(int[] a, int i) {
        int left = left(i);
        int right = right(i);
        int largestIndex = i;
        if (left < heapSize && a[i] < a[left]) {
            largestIndex = left;
        }
        if (right < heapSize && a[largestIndex] < a[right]) {
            largestIndex = right;
        }
        if (i != largestIndex) {
            swap(a,i,largestIndex);
            heapify(a,largestIndex);
        }
    }

    private void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return 2*i+2;
    }

}
