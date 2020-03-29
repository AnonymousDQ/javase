package algorithm.add_binary;

/**
 * @Description:二进制求和 给定两个二进制字符串，返回他们的和，用二进制表示。
 * 输入为：非空字符串，只包含0或者1
 * 例子：输入：a=11,b=1
 * 输出：100
 * 输入：a=1010,b=1011
 * 输出10101
 * @Author: VictorDan
 * @Date: 19-8-8 下午2:02
 * @Version: 1.0
 */
public class AddTwoBinaryNum {
    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String s = addBinary(a, b);
        System.out.print("a+b=" + s);
    }
}
