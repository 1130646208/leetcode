package com.wsx.alogrithm;

import java.util.Arrays;

/**
 * @author shuangxing.wang
 * @date 2021/7/17
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12,34,2,3,99,6,54,3,2,1,0,9,77,6,5,444,3,3,2,2};
        mergeSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);

    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l+r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);

    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int i=l, j=mid+1, k=0;
        while (i <= mid && j <= r){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, l, r-l+1);
    }
}
