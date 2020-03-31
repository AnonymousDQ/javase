package algorithm.linkedlist;

/**
 * @Description:双向链表的节点
 * @Author: VictorDan
 * @Date: 20-3-30 下午6:45
 * @Version: 1.0
 */
public class DoubleListNode {
    /**
     * 编号
     */
    public int no;
    /**
     * 名字
     */
    public String name;
    /**
     * 昵称
     */
    public String nickName;
    /**
     * 指向下一个节点，默认为null
     */
    public DoubleListNode next;
    /**
     * 指向前一个节点，默认为null
     */
    public DoubleListNode pre;

    public DoubleListNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    /**
     * 为了显示方便，我们重写toString方法
     */
    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
