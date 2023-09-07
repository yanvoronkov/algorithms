package ru.geekbrains.lesson2.homework;

public class Hw1 {
    public static void heapSort(int[] array) {

        int n = array.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // one by one extract an element from heap
        for (int i=n-1; i>=0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void printArray(int[] arr) {
        for (int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String args[]) {

        int[] arr = new int[10];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (int) (Math.random() * 100);
        }
//        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println("Sorted array is");
        printArray(arr);
    }

}

