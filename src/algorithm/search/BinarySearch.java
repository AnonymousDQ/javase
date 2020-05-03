package algorithm.search;

/**
 * @Description:二分查找的前提必须是数组有序
 * @Author: VictorDan
 * @Date: 20-4-2 下午1:45
 * @Version: 1.0
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int x) {
        //取mid为left和right的中点
        int mid;
        //如果left>right就没办法形成闭区间
        while (left <= right) {
            //取中点
            //mid = (left + right) / 2;
            //如果二分上界超过int数据范围的一般，那么mid = (left + right) / 2会导致溢出
            // ，避免溢出，可使用以下方法。
            mid = left + (right - left)/2;
            //找到x，则返回下标
            if (arr[mid] == x) {
                return mid;
                //x小于中间的数
            } else if (arr[mid] > x) {
                //往左子区间[left,mid-1]查找
                right = mid - 1;
                //x大于中间的数
            } else {
                //往右子区间[mid+1,right]查找
                left = mid + 1;
            }
        }
        //查找失败，返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,4,6,7,8,10,11,13,15};
        System.out.printf("要查找的x为%d,位置在%d\n",6,binarySearch(arr,0,arr.length,6));
    }
}
