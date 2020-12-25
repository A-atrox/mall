package everyDayAlgorithm;

import cn.hutool.http.Method;
import org.apache.commons.collections.ListUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpCookie;
import java.util.*;

/**
 * @author guoyf
 * @version 1.0
 * @date 2020/11/16 21:28
 * @description
 */
public class Algorithm {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        System.out.println(Arrays.toString(threeSum(nums).toArray()));
//        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        Algorithm algorithm = new Algorithm();
//        System.out.println(algorithm.matrixScore(A));
//        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
//        System.out.println(Arrays.toString(algorithm.dailyTemperatures(T)));
        int[] g = {1, 2};
        int[] s = {1, 2,3};
        System.out.println(algorithm.findContentChildren(g, s));
    }

    /**
     * 11.15 股票交易
     */
    public static void buyAndSell(int[] price) {
//         int price[] = {2, 1, 9, 7, 8, 10, 6};
        int sum = 0;
        for (int i = 1; i < price.length - 1; i++) {
            int temp = price[i] - price[i - 1];
            if (temp > 0) {
                sum += temp;
            }
        }
        System.out.println(sum);
    }

    /**
     * 11.18加油站
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
        // i代表出发起点
        for (int i = 0; i < gas.length; i++) {
            //初始汽油
            int curGas = 0;
            int rightIndex = i;
            int leftIndex = 0;
            //能走通右边的标志
            boolean right = true;
            //能走通左边的标志
            boolean left = true;
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

    /**
     * 11.19最多水容器
     */
    public static int maxArea(int[] height) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        if (height.length == 2) {
            return Math.min(height[0], height[1]) * 1;
        }
        // 从第一个柱子开始往后遍历
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int curMax = minHeight * (right - left);
            max = Math.max(curMax, max);
            // 判断现在是左边短板 还是右边短板  如果是左边短板那就往左边再找
            if (height[left] < height[right]) {
                while (height[left] <= minHeight && left < right) {
                    left++;
                }

            } else {
                while (height[right] <= minHeight && left < right) {
                    right--;
                }

            }
        }

        return max;
    }

    /**
     * 三数之和
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int x1;
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            x1 = i + 1;
            if (nums[i] > 0) {
                break;
            }
            while (x1 < nums.length) {
                int temp = -(nums[i] + nums[x1]);
                if (map.containsKey(temp) && map.get(temp) != i && map.get(temp) != x1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[x1]);
                    list.add(nums[map.get(temp)]);
                    Collections.sort(list);
                    result.add(list);
                }
                x1++;
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = -nums[i];
        }
        return result;
    }

    /**
     * 链表插入排序
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /***
     * 861:翻转矩阵后得分
     */
    public int matrixScore(int[][] A) {
        int sum = 0;
        // 遍历第一列 使其全为1 行转换
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                A = rowFlip(A, i);
            }
        }
        sum += A.length * (1 << (A[0].length - 1));
        // 遍历剩余几列   列转换  使其可以有最多的1
        for (int j = 1; j < A[0].length; j++) {
            int oneSum = 0, zeroSum = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    zeroSum++;
                } else {
                    oneSum++;
                }
            }
            if (zeroSum > oneSum) {
//                A = columnFlip(A, j);
                sum += zeroSum * (1 << (A[0].length - j - 1));
            } else {
                sum += oneSum * (1 << (A[0].length - j - 1));
            }
        }
//        Arrays.stream(A).forEach(a -> System.out.println(Arrays.toString(a)));
        return sum;
    }

    /**
     * @return int[][]
     * @Description 行转换
     * @Param [A, rIndex]
     * @author guoyf
     * @date 2020/12/7 16:52
     */
    public int[][] rowFlip(int[][] A, int rIndex) {
        int rLength = A.length - 1;
        if (rIndex > rLength) {
            //如果是无效rIndex那就啥也都不做
            return A;
        }
        for (int i = 0; i < A[0].length; i++) {
            A[rIndex][i] = conversion(A[rIndex][i]);
        }
        return A;
    }

    /**
     * @return int[][]
     * @Description 列转换
     * @Param [A, cIndex]
     * @author guoyf
     * @date 2020/12/7 16:51
     */
    public int[][] columnFlip(int[][] A, int cIndex) {
        int cLength = A[0].length - 1;
        if (cIndex > cLength) {
            //如果是无效rIndex那就啥也都不做
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            A[i][cIndex] = conversion(A[i][cIndex]);
        }
        return A;
    }

    public int conversion(int temp) {
        return temp == 0 ? 1 : 0;
    }

    /**
     * @return int[]
     * @Description 每日温度观测
     * @Param [T]
     * @author guoyf
     * @date 2020/12/8 14:40
     */
    public int[] dailyTemperatures(int[] T) {

        if (T.length == 0) {
            return null;
        }
        int[] out = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < T.length) {
                if (T[j] > T[i]) {
                    out[i] = j - i;
                    break;
                } else if (out[j] == 0) {
                    break;
                } else {
                    j += out[j];
                }
            }
        }
        return out;
    }

    /**
     * @return int
     * @Description 饼干分发
     * @Param [g, s]
     * @author guoyf
     * @date 2020/12/25 15:13
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int sum = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                sum++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return sum;
    }
}
