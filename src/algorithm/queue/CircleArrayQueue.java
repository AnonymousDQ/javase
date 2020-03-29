package algorithm.queue;

/**
 * @Description:用数组实现环形队列
 * @Author: VictorDan
 * @Date: 20-3-28 下午7:45
 * @Version: 1.0
 */
public class CircleArrayQueue {
    /**
     * 数组的最大容量
     * 如果maxSize为1时候，不存在所谓的环，会导致数据插不进去
     */
    private int maxSize;
    /**
     * front变量的含义做个调整：
     * front就指向队列的第一个元素，也就是说arr[front]就是队列的第1个元素，front的初始值为0
     */
    private int front;
    /**
     * rear变量的含义做一个调整：
     * rear指向队列的最后一个位置，因为希望空出一个空间做为约定，rear的初始值为0
     */
    private int rear;
    /**
     * 该数组用于存放数据
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     *
     * @param maxSize 最大容量
     */
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //因为整形成员变量已经默认值是0可以以下不用写
//        front = 0;
//        rear = 0;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 队列添加数据
     *
     * @param data
     */
    public void addQueue(int data) {
        //判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加数据！");
        } else {
            //因为环形队列rear从0开始的真实的位置
            arr[rear] = data;
            //添加数据从队尾添加，让rear后移，这里必须考虑取模
            //加入rear已经取到最后了，然后我还要添加然后rear+1取模maxSize到front位置。
            rear = (rear + 1) % maxSize;
        }
    }

    /**
     * 队列取出数据
     *
     * @return
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据！");
        } else {
            /**
             * front是指向队列的第一个元素
             * 1、先把front对应的值保留到一个临时变量中,因为如果不保存，则直接返回，front无法进行下一步后移操作了。
             * 2、将front后移，也需要取模
             * 3、将临时保存的变量值返回
             */
            int temp = arr[front];
            front = (front + 1) % maxSize;
            return temp;
        }
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
        } else {
            /**
             * 思路：从front开始遍历，遍历多少个元素,也就是环形队列中有多少个有效数字，(rear-front+maxSize)%maxSize
             */
            for (int i = front; i < front + size(); i++) {
                //因为是环形的i可能超过maxSize，所以你需要取模maxSize来获取在环形队列中的位置。
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 返回队列的头部数据，有的方法是peek()
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据！");
        } else {
            //因为front本身是指向队列的第一个元素
            return arr[front];
        }
    }
}
