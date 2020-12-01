package everyDayAlgorithm;

import org.apache.commons.collections.ListUtils;

import java.util.*;

/**
 * @author guoyf
 * @version 1.0
 * @date 2020/11/16 21:28
 * @description
 */
public class Algorithm {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
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

}
