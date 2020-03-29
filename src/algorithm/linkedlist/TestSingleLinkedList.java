package algorithm.linkedlist;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 20-3-29 下午5:03
 * @Version: 1.0
 */
public class TestSingleLinkedList {
    public static void main(String[] args) {
        /**
         * 进行测试
         * 1、先创建节点
         */
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "公孙胜", "入云龙");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        /**
         * 1、加入节点
         */

//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);
        //显示
//        singleLinkedList.show();

        /**
         * 2、按照编号 顺序添加
         */
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node1);
        //显示
        singleLinkedList.show();

        /**
         * 3、测试修改节点的代码
         */
        Node newNode = new Node(2, "林冲", "豹子头");
        singleLinkedList.update(newNode);
        System.out.println("修改链表后的结果显示：");
        singleLinkedList.show();

        /**
         * 4、删除一个节点
         */
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
        System.out.println("删除后的链表情况：");
        singleLinkedList.show();

        /**
         * 5、求单链表中有效节点的个数
         */
        Node head = singleLinkedList.getHead();
        int length = singleLinkedList.getLength(head);
        System.out.printf("单链表中有效节点的个数为：%d\n",length);
    }

}
