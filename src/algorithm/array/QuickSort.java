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
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < privo) {
                left++;
            }
            while (left <= right && nums[right] > privo) {
                right--;
            }
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
