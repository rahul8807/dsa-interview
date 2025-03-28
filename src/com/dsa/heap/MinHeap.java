package com.dsa.heap;

import java.util.Arrays;

public class MinHeap {
    int[] heap = new int[100];
    int size = 0;

    public boolean insert ( Integer i ) {
        heap[size] = i;
        heapifyUp ( size );
        size++;
        return true;
    }

    public Integer pop ( ) {
        if(size == 0){
            return 0;
        }

        int data = heap[0];

        heap[0] = heap[size - 1];
        heap[size-1] = 0;
        size--;

        heapifyDown ( 0 );

        return data;
    }

    private void heapifyDown(int index){

        if(index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int lowestIndex = index;

            if (left < size && heap[left] < heap[lowestIndex]) {
                lowestIndex = left;
            }

            if (right < size && heap[right] < heap[lowestIndex]) {
                lowestIndex = right;
            }

            //swap
            if(index != lowestIndex) {
                swap ( index, lowestIndex );
                heapifyDown ( lowestIndex );
            }
        }
    }

    private void heapifyUp ( Integer i ) {
        int parent = (i - 1) / 2;
        if (parent >= 0) {
            if (heap[i] < heap[parent] ) {
                swap ( parent, i );
                heapifyUp ( parent );
            }
        }
    }

    public void swap ( int parent, int child ) {
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }


    public static void main ( String[] args ) {
        MinHeap minHeap = new MinHeap ();
        minHeap.insert ( 50 );
        minHeap.insert ( 8 );
        minHeap.insert ( 89 );
        minHeap.insert ( 5 );
        minHeap.insert ( 99 );

        System.out.println ( Arrays.toString ( minHeap.heap));
        System.out.println ("Pop "+ minHeap.pop ());
        System.out.println ( Arrays.toString ( minHeap.heap));
        System.out.println ("Pop "+ minHeap.pop ());
        System.out.println ( Arrays.toString ( minHeap.heap));
        System.out.println ("Pop "+ minHeap.pop ());
        System.out.println ( Arrays.toString ( minHeap.heap));
    }
}