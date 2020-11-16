package com.macro.mall.util.sort;


/**
 * @author guoyf
 * @version 1.0
 * @date 2020/11/16 15:54
 * @description
 */
public class BiSearch {
    private int[] arr;
    private int arrLength;

    BiSearch(int[] arr) {
        this.arr = arr;
        this.arrLength = arr.length;
    }

    public int biSearch(int target,int end) {
        // 要搜索的end
        arrLength = end;
        if (arrLength == 0) {
            return -1;
        }
        if (arr[0] > target) {
            return 0;
        }
        if (arr[arrLength - 1] < target) {
            return arrLength;
        }
        int left = 0;
        int right = (arrLength - 1);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid] || left == right) {
                return mid + 1;
            }
            if (target > arr[mid]) {
                left = mid + 1;
                continue;
            }
            if (target < arr[mid]) {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 9, 20};
        BiSearch biSearch = new BiSearch(arr);
        System.out.println(biSearch.biSearch(4,arr.length));
    }
}
