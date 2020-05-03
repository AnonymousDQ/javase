package algorithm.array;

import java.util.Arrays;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 20-3-31 下午1:54
 * @Version: 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 0, 1, 2};
        int[] quickSort = quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(quickSort));
    }

    /**
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int[] quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return nums;
        }
        int privo = nums[(start + end) / 2];
        //双指针
        int left = start, right = end;
        while (left <= right) {
            //双指针，只要最左边小于基准值，则往右边移动left++
            while (left <= right && nums[left] < privo) {
                left++;
            }
            //只要右边的元素大于基准值，则往左边移动right--
            while (left <= right && nums[right] > privo) {
                right--;
            }
            //直到两个移动位置重合，然后交换位置
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(nums, start, right);
        quickSort(nums, left, end);
        return nums;
    }

}
