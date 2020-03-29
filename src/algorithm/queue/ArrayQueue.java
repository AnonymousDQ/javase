package algorithm.queue;

/**
 * @Description:用数组模拟的队列
 * 这个有缺陷，当添加队列满了以后，然后把数据都取出来后，再继续添加发现提示队列已满，是因为数据组没有重复使用
 * 没有成为环形。是因为此时指针front已经变为-1，而rear变为maxSize-1
 * 所以当你add数据的时候rear等于maxSize-1所以无法插入数据
 * 而当你要get数的时候front已经为-1所以无法取出数据。
 * @Author: VictorDan
 * @Date: 20-3-28 下午4:09
 * @Version: 1.0
 */
public class ArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
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
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头的前一个位置，因为数组是从0开始的，你取出一个数，然后front从-1变为0
        front = -1;
        //指向队列尾的前一个位置，因为数组是从0开始，你存一个数到数组0下标位置，然后rear从-1变为0
        rear = -1;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
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
            throw new RuntimeException("队列为空，无法添加数据！");
        } else {
            //添加数据从队尾添加，让rear后移
            rear++;
            arr[rear] = data;
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
            //front后移
            front++;
            return arr[front];
        }
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
        } else {
            //这里从i=0开始是打印出所有数据，如果队列有取出元素操作，则应该i从front+1开始打印后面没有取出的元素比较好
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }
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
            //因为front本身是指向队列头的前一个位置，所以取出队列头数据，需要front+1
            return arr[front + 1];
        }
    }
}
