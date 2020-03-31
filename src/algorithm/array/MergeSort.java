package algorithm.array;

import java.util.Arrays;

/**
 * @Description:归并排序
 * @Author: VictorDan
 * @Date: 20-3-31 下午1:54
 * @Version: 1.0
 */
public class MergeSort {

    private static int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    //归并排序
    private static void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, end, temp, mid);
    }

    private static void merge(int[] nums, int start, int end, int[] temp, int mid) {
        int left = start, right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }
        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] arr={2,3,1,5,21,7,9,0,1,21,10,6,4,3,2};
        int[] sortArray = sortArray(arr);
        System.out.println(Arrays.toString(sortArray));
    }
}
