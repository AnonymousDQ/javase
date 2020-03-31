package algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:使用两个队列模拟栈
 * @Author: VictorDan
 * @Date: 20-3-31 下午1:53
 * @Version: 1.0
 */
public class StackByTwoQueue {
    /**
     * 输入队列
     */
    private Queue<Integer> rear;
    /**
     * 输出队列
     */
    private Queue<Integer> front;

    public StackByTwoQueue() {
        rear=new LinkedList<>();
        front=new LinkedList<>();
    }

    public void push(int data){
        rear.offer(data);
        /**
         * 将front队列里的元素全部转到a对了
         */
        while (!front.isEmpty()){
            rear.offer(front.poll());
        }
        Queue<Integer> temp = rear;
        rear=front;
        front=temp;
    }

    public Integer pop(){
        return front.poll();
    }

    public Integer top(){
        return front.peek();
    }
    public Boolean isEmpty(){
        return front.isEmpty();
    }
}
