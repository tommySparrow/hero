package com.house.hero;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 5, 3, 0, 1, 7, 2, 6};
        bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr 数组
     * @param sz 数组大小
     */
    private static void bubbleSort(int[] arr, int sz) {

        for (int i = 0; i < sz - 1; ++i) {
            for (int j = 0; j < sz - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
