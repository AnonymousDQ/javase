package algorithm.linkedlist;

/**
 * @Description:定义Node，每个Node对象就是一个节点
 * @Author: VictorDan
 * @Date: 20-3-22 下午5:27
 * @Version: 1.0
 */
public class Node {
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
     * 指向下一个节点
     */
    public Node next;

    public Node(int no, String name, String nickName) {
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
