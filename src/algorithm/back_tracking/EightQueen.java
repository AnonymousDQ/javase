package algorithm.back_tracking;

import static java.lang.Math.max;

/**
 * @Description:回溯法
 * 1、在解空间树中，从根节点出发，采用深度优先有所的思想来遍历解空间树。每一次遍历节点时都判断当前节点是否为
 * 合法解决、，如果是合法解决，那么继续遍历子树，如果不是合法节点，那么访问它的下一个兄弟节点。如果没有
 * 下一个兄弟节点就退回到父节点(回溯)，访问父节点的下一个兄弟节点。
 * 2、回溯法结束的条件是回溯到根节点而且所有子树均已遍历到
 * 3、回溯法归根结底还是一种带有节点判断条件的深度优先搜索算法。
 * @Author: VictorDan
 * @Date: 19-8-7 下午3:24
 * @Version: 1.0
 */
public class EightQueen {
    private int count;
    /**
     * 一共有多少个皇后，8*8棋盘，可以修改值在设置为N皇后问题
     */
    private int max=8;
    /**
     * 数组用来保存结果，第一个皇后摆在arr[0]列，第二个摆在arr[1]
     */
    private int[] arr=new int[max];

    private int check(int n){

        /**
         * 结束条件是，最后一行已经摆完，也就是n为8的时候，因为每次摆一行都会判断，只要最后一行摆完就说明得到一个正确解
         * 因为是从0开始的，最后一行就是7，所以当n为8的时候已经摆完最后一行
         */
        if(n==max){
            count++;
            print();
        }else{
            /**
             * 从第一行开始摆，判断是否和本行本列本斜线有冲突，如果无冲突为true，就下一行。
             */
            for (int i = 0; i < max; i++) {
                arr[n]=i;
                if(judge(n)){
                    check(n+1);
                }
            }
        }
        //计数器返回八皇后的总共摆法
        return count;
    }

    /**
     * o x x x x x x x
     * x x x x o x x x
     * x x x x x x x o
     * x x x x x o x x
     * x x o x x x x x
     * x x x x x x o x
     * x o x x x x x x
     * x x x o x x x x
     * @param n
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            /**
             * 判断是否在同一列，只要看arr这两个位置上的数字是否相同
             * 判断是否在同一斜线，将棋盘看成一个二维数组，因为不用的棋子在不同行，所以纵坐标就是哪个棋子，横坐标就是列
             * 如果两个棋子坐标（a1,b1）,(a2,b2),当|a2-a1|=|b2-b1|时，表明不在同一斜线。
             */
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
    private void print(){
        for (int value : arr) {
            System.out.print(value + 1 + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        //从第0行开始检测，是否满足条件
        int check = queen.check(0);
        System.out.println("八皇后总共有的摆法："+check);
    }

}


