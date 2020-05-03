package algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:删除排序数组的重复项
 * @Link:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Author: VictorDan
 * @Date: 20-4-2 上午11:32
 * @Version: 1.0
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums,int target){
        if(nums.length==0) {
            return 0;
        }
        //双指针解法
        int flag=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=target){
                nums[flag++]=nums[i];
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = new int[]{0,0,1,1,1,1,2,2,3,3,4};
        int size = removeDuplicates.removeDuplicates(nums,3);
        System.out.println(size);
    }
}
