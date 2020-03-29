package algorithm.array;

/**
 * @Description:稀疏数组的应用
 * @Author: VictorDan
 * @Date: 20-3-27 下午7:09
 * @Version: 1.0
 */
public class SparseArr {
    public static void main(String[] args) {
        /**
         * 创建一个二维数组
         * 0：表示没有棋子
         * 1：表示黑棋
         * 2：表示白棋
         */
        int[][] originArr = new int[11][10];
        originArr[1][2] = 1;
        originArr[2][3] = 2;
        System.out.println("原始的二维数组为：");
        for (int[] ints : originArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        /**
         * 将二维数组转换为稀疏数组
         */
        int count = 0;
        for (int[] arr : originArr) {
            for (int data : arr) {
                if (data != 0) {
                    count++;
                }
            }
        }
        /**
         * 创建对应的稀疏数组,因为数组下标是从0开始的，所有要+1
         */
        int[][] spareArr = new int[count + 1][3];
        //稀疏数组的第1行第1列记录二维数组有多少行
        spareArr[0][0] = originArr.length;
        //稀疏数组的第1行第2列记录二维数组有多少列
        spareArr[0][1] = originArr[0].length;
        spareArr[0][2] = count;
        //遍历二维数组将非0元素的行和列的位置以及值存到稀疏数组
        //flag用来记录第几个非0数据
        int flag = 0;
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[i].length; j++) {
                if (originArr[i][j] != 0) {
                    flag++;
                    //稀疏数组第1列记录行
                    spareArr[flag][0] = i;
                    //稀疏数组第2列记录列
                    spareArr[flag][1] = j;
                    //稀疏数组第3列记录值
                    spareArr[flag][2] = originArr[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int[] arr : spareArr) {
            for (int data : arr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * 将稀疏数组转为二维数组
         */
        int row = spareArr[0][0];
        int column = spareArr[0][1];
        int[][] arr = new int[row][column];
        for (int i = 1; i < spareArr.length; i++) {
            //稀疏数组的第i行第0列是原始数组的行
            //稀疏数组的第i行第1列是原始数组的列
            //稀疏数组的第i行第2列是原始数组的值
            arr[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }
        System.out.println("稀疏数组转为二维数组：");
        for (int[] rowArr : arr) {
            for (int data : rowArr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
