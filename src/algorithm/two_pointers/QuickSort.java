package algorithm.two_pointers;

import java.util.Arrays;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 20-4-2 下午2:52
 * @Version: 1.0
 */
public class QuickSort {
    /**
     * 对[left,right]区间划分
     * 思路：
     * 1、将两个下标left，right分别指向数组的首尾，比如left=0,right=n-1
     * 2、用一个临时变量temp先把arr[left+right/2]存放到temp
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        //1、将arr[left]存放到临时变量temp
        int temp = arr[left];
        //2、只要left与right不相遇就遍历
        while (left < right) {
            //反复左移动right
            while (left < right && arr[right] > temp) {
                right--;
            }
            //将arr[right]挪到arr[left]
            arr[left] = arr[right];
            //反复右边移动left
            while (left < right && arr[left] <= temp) {
                left++;
            }
            //将arr[left]挪到arr[right]
            arr[right] = arr[left];
        }
        //3、left与right相遇的地方，把temp放到left与right相遇的地方
        arr[left] = temp;
        //4、返回相遇的下标
        return left;
    }
    private static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int pos=partition(arr,left,right);
            quickSort(arr,left,pos-1);
            quickSort(arr,pos+1,right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 0, 1, 2};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }
}
