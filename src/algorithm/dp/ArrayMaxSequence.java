package algorithm.dp;

import static java.lang.Math.max;

/**
 * @Description: 求数组最大连续子序列
 * @Author: VictorDan
 * @Date: 20-3-27 下午5:53
 * @Version: 1.0
 */
public class ArrayMaxSequence {
    /**
     * 动态规划：求数组最大连续子序列
     * @param args
     */
    public static void main(String[] args) {
        int[] arr={6,-1,3,-4,-6,9,2,-2,5};
        int maxArraySum = maxArraySum(arr);
        System.out.println("数组最大连续子序列和为："+maxArraySum);
        int[] data = maxSumSequence(arr);
        for (int datum : data) {
            System.out.printf("%d\t",datum);
        }

    }

    private static int maxArraySum(int[] a){
        int max=a[0];
        int sum=a[0];
        for (int i = 1; i < a.length; i++) {
            sum=max(sum+a[i],a[i]);
            if(sum>=max){
                max=sum;
            }
        }
        return max;
    }

    /**
     * 打印数组连续的最大和
     * @param arr
     * @return
     */
    private static int[] maxSumSequence(int[] arr){
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        int sum = arr[0];
        for (int i = 1; i<arr.length; i++)
        {
            sum += arr[i];
            sum = max(arr[i], sum);
            temp[i] = max(temp[i-1], sum);
        }
        return temp;
    }
}
