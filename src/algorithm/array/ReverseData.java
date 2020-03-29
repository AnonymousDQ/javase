package algorithm.array;

/**
 * @Description:数组的子列倒序
 * @Author: VictorDan
 * @Date: 20-3-22 下午1:17
 * @Version: 1.0
 */
public class ReverseData {
    private static void swap(int[] arr, int left, int right) {
        int temp;
        for (int i = left, j = right; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void reverse(int[] arr, int n, int p) {
        if (p <= 0 || p >= n) {
            System.out.println("Error");
        } else {
            swap(arr, 0, p - 1);
            swap(arr, p, n - 1);
            swap(arr, 0, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        reverse(arr, arr.length, 5);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }


}
