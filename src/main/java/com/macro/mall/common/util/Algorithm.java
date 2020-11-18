package com.macro.mall.common.util;

/**
 * @author guoyf
 * @version 1.0
 * @date 2020/11/16 21:28
 * @description
 */
public class Algorithm {
    public static void main(String[] args) {
//        int price[] = {2, 1, 9, 7, 8, 10, 6};
//        int sum = 0;
//        for (int i = 1; i < price.length-1; i++) {
//            int temp = price[i] - price[i-1];
//            if(temp>0){
//                sum+=temp;
//            }
//        }
//        System.out.println(sum);
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static  int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) { // i代表出发起点
            int curGas = 0;//初始汽油
            int rightIndex = i;
            int leftIndex = 0;
            boolean right = true;//能走通右边的标志
            boolean left = true;//能走通左边的标志
            // 往前走
            while (rightIndex < gas.length) {
                curGas += gas[rightIndex];
                // 如果当前位置支持向前出发
                curGas -= cost[rightIndex];
                if (curGas >= 0) {
                    rightIndex++;
                } else {
                    right = false;
                    break;
                }
            }
            // 如果能走通右边 再考虑走左边
            if (right) {
                while (leftIndex < i) {
                    // 获取当前汽油
                    curGas += gas[leftIndex];
                    curGas -= cost[leftIndex];
                    if (curGas >= 0) {
                        leftIndex++;
                    } else {
                        left = false;
                        break;
                    }
                }
            }
            if (right && left) {
                return i;
            }
        }
        return -1;
    }
}
