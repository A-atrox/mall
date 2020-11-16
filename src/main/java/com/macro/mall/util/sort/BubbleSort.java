package com.macro.mall.util.sort;

import java.util.Arrays;

/**
 * @author guoyf
 * @version 1.0
 * @date 2020/11/16 16:24
 * @description
 */
public class BubbleSort {
    private int[] arr;
    private int arrLength;

    BubbleSort(int[] arr) {
        this.arr = arr;
        arrLength = arr.length;
    }

    private int[] bubbleSort() {
        if (arrLength < 2) {
            return arr;
        }
        int tranIndex = 0;
        for (int i = 0; i < arrLength - 2; i++) {
            boolean sortFlag = true;
            int l = tranIndex, r = tranIndex + 1;
            for (; r < arrLength; l++, r++) {
                if (arr[l] > arr[r]) {
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    if (sortFlag == true) {
                        tranIndex = l;
                    }
                    sortFlag = false;
                }
            }
            if (sortFlag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 73, 21, 65, 88};
        BubbleSort bubbleSort = new BubbleSort(arr);
        System.out.println(Arrays.toString(bubbleSort.bubbleSort()));
    }
}
