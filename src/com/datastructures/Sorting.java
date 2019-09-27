package com.datastructures;

import java.util.Random;

public class Sorting {
    public static void sort( int arr[] ) {

        int N = arr.length;
        int i, j, temp;
        for (i = 1; i< N; i++)
        {
            j = i;
            temp = arr[i];
            while (j > 0 && temp < arr[j-1])
            {
                arr[j] = arr[j-1];
                j = j-1;
            }
            arr[j] = temp;
        }
        System.out.println("Insertion sort: ");
        display(arr);
    }

    public static void bubbleSort(int arr[]){
        int N = arr.length;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Bubble sort: ");
        display(arr);
    }

    public static void selectionSort(int arr[]){

        int N = arr.length;

        for(int i = 0; i < N-1; i++){
            int minPos = i;
            for(int k = i+1; k < N; k++){
                if(arr[k] < arr[minPos]){
                    minPos = k;
                }
             int min = arr[minPos];
             arr[minPos] = arr[i];
             arr[i] = min;
            }
        }
        System.out.println("Selection sort: ");
        display(arr);
    }

    public static void mergeSort(int[] a, int low, int high)
    {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N/2;
        // recursively sort
        mergeSort(a, low, mid);
        mergeSort(a, mid, high);
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++)
        {
            if (i == mid)
                temp[k] = a[j++];
            else if (j == high)
                temp[k] = a[i++];
            else if (a[j]<a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[low + k] = temp[k];
    }

    public static void display(int arr[]){
        for(int y = 0; y < arr.length; y++)
            System.out.print(arr[y]+" ");
    }

    public static void main(String[] args){

        Random r = new Random();
       int arr[] = {10,4,2,1,8,5,9,4,};//3,5,12,3,567,987,452,6,357,37,65,73,63,5,14,514,63,7,68,7,89,36,34,5,3,765,76,6,875,6};
       // int arr[] = new int[6];
        /*for(int i = 0; i < 6; i++){
            arr[i] = r.nextInt(10);
        }*/
        /*sort(arr);
        bubbleSort(arr);
        selectionSort(arr);*/
        mergeSort(arr,0,arr.length);
        display(arr);
    }
}
