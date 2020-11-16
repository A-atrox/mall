package com.macro.mall.util.sort;

import java.util.Arrays;

/**
 * @author guoyf
 * @version 1.0
 * @date 2020/11/16 17:31
 * @description
 */
public class InsertSort {
    private int[] arr;
    private int arrLength;

    public InsertSort(int[] arr) {
        this.arr = arr;
        this.arrLength = arr.length;
    }

    private int[] insertSort() {
        for (int begin = 1; begin < arrLength; begin++) {
            // 记录当前要插入的位置
            int cur = begin;
            //如果当前位置大于0并且要插入的数小于前面的数 那么交换 cur--，继续循环和前面的比较
            while (cur > 0 && arr[cur] < arr[cur - 1]) {
                int temp = arr[cur];
                arr[cur] = arr[cur - 1];
                arr[cur - 1] = temp;
                cur--;
            }
        }
        return arr;
    }

    private int[] insertSortMax() {
        for (int begin = 1; begin < arrLength; begin++) {
            // 记录当前要插入的位置和值
            int cur = begin;
            int curVal = arr[cur];
            //如果当前位置大于0并且要插入的数小于前面的数 那么前面的数就都向后移动一位
            while (cur > 0 && arr[cur] < arr[cur - 1]) {
                arr[cur] = arr[cur - 1];
                cur--;
            }
            // 在合适的位置放入cur
            arr[cur] = curVal;
        }
        return arr;
    }

    private int[] insertSortMax2() {
        BiSearch biSearch = new BiSearch(arr);
        for (int begin = 1; begin < arrLength; begin++) {
            // 记录当前要插入的位置和值
            int cur = begin;
            int curVal = arr[cur];
            //使用二分搜索得到待插入的位置，end为已经排好序的数组下标
            int index = biSearch.biSearch(curVal, cur+1);
            // 移动
            while (cur > 0 && cur > index) {
                arr[cur] = arr[cur - 1];
                cur--;
            }
            // 在合适的位置放入curVals
            arr[cur] = curVal;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 73, 21, 65, 88};
        InsertSort insertSort = new InsertSort(arr);
//        System.out.println(Arrays.toString(insertSort.insertSort()));
//        System.out.println(Arrays.toString(insertSort.insertSortMax()));
//        System.out.println(Arrays.toString(insertSort.insertSortMax2()));
    }
}
