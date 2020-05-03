package algorithm.search;

/**
 * @Description:使用二分法，实现快速幂
 * @Author: VictorDan
 * @Date: 20-4-2 下午2:00
 * @Version: 1.0
 */
public class QuickPow {
    /**
     * 快速幂思路：a^b%m
     * 基于二分的思想，也叫二分幂
     * 1、如果b是奇数，那么a^b=a*a^b-1
     * 2、如果b为偶数，那么有a^b=a^(b/2)*a^(b/2)
     * b为奇数的情况，总可以在下一步转化为b为偶数的情况
     * 而b为偶数，可以在下一步转化为b/2的情况。
     * 这样时间复杂度为O(logb)
     *
     * @param a
     * @param b
     * @param m
     * @return
     */
    public static long binaryPow(long a, long b, long m) {
        long res = 1L;
        if (b == 0) {
            return res;
        } else if (b % 2 == 1) {
            /**
             * if(b%2==1)可以写成if(b&1)代替，因为b&1进行位与操作，判断
             * b的末位是否为1，当b为奇数时，b&1返回为1成立。这样写的速度快点。
             */
            //如果b为奇数，转化为b-1
            return a * binaryPow(a, b - 1, m) / m;
        } else {
            /**
             * 如果b为偶数，不要返回binaryPow(a, b / 2, m)*binaryPow(a, b / 2, m)
             * 应该先计算单个之后再撑起来。否则会调用两次函数，导致复杂度变由O(logb)变为O(b)
             */
            //如果b为偶数。转化为b/2
            res = binaryPow(a, b / 2, m);
            return res * res / m;
        }
    }

    public static long binaryPow1(long a, long b, long m) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = res * a / m;
            }
            a = a * a / m;
            //将b的二进制右移一位，b=b>>1，b=b/2
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        long res = binaryPow(2, 10, 1);
        long res1 = binaryPow1(2, 10, 1);
        System.out.println(res1);
        System.out.println(res);
    }
}
