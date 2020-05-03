package algorithm.two_pointers;

import java.util.Arrays;

/**
 * @Description:双指针
 * @Author: VictorDan
 * @Date: 20-4-2 下午2:28
 * @Version: 1.0
 */
public class TwoPointers {
    /**
     * 给定一个递增的正整数序列arr，和一个正整数x，求序列中2个不同位置的数a，b，让它两的和为x
     * 最直观的想法：使用二重循环枚举序列。显然这样时间复杂度为O(n^2)
     * 分析：
     * 1、对于一个确定的arr[j]，如果当前的arr[j]满足arr[i]+arr[j]>x，显然arr[i]+arr[j+1]>x都会成立，因为数组是递增
     * 所以会导致对j进行了大量无效枚举。效率自然低
     * 2、对于某个arr[i]如果找到一个arr[j],如果arr[i]+arr[j]>x已经成立，那么对于arr[i+1]来说，也一定是arr[i+1]+arr[j]>x
     * 因此在arr[i]之后也不用继续去枚举。
     * 3、i和j的枚举似乎是互相前置的，这样给优化算法带来很大的空间。
     * 思路：
     * 1、如果arr[i]+arr[i]=x，说明已经找到，由于arr是递增，a[i+1]+a[j]>x和a[i]+a[j-1]<x都成立。
     *
     * @param arr
     * @param x
     * @return
     */
    public static int[] getTarget(int[] arr, int x) {
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == x) {
                    res[0] = arr[i];
                    res[1] = arr[j];
                }
            }
        }
        return res;
    }

    public static int[] get(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int[] res = new int[2];
        while (i < j) {
            if (arr[i] + arr[j] == target) {
                res[0] = arr[i];
                res[1] = arr[j];
                i++;
                j--;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] target = getTarget(arr, 8);
        System.out.println(Arrays.toString(target));
        int[] res = get(arr, 8);
        System.out.println(Arrays.toString(res));
    }
}
