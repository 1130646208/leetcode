package com.wsx.alogrithm;

import java.util.stream.Stream;

/**
 * @author shuangxing.wang
 * @date 2021/7/17
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1,23,2,65,76,21,11,2,34};
        quickSort(arr, 0, arr.length-1);

        for (int i: arr){
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int l, int r){
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        while (i < j){
            while (i < j && arr[j] >= arr[l]) {
                j --;
            }
            while (i < j && arr[i] <= arr[l]) {
                i ++;
            }
            swap(arr, i, j);
        }
        swap(arr, l, i);
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
