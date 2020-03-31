package algorithm.linkedlist;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 20-3-30 下午7:05
 * @Version: 1.0
 */
public class TestDoubleLinkedList {
    public static void main(String[] args) {
        System.out.println("双向链表的测试：");
        /**
         * 进行测试
         * 1、先创建节点
         */
        DoubleListNode node1 = new DoubleListNode(1, "宋江", "及时雨");
        DoubleListNode node2 = new DoubleListNode(2, "卢俊义", "玉麒麟");
        DoubleListNode node3 = new DoubleListNode(3, "吴用", "智多星");
        DoubleListNode node4 = new DoubleListNode(4, "公孙胜", "入云龙");

        //2、创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);

        doubleLinkedList.show();

        //3、双向链表的修改
        DoubleListNode newNode = new DoubleListNode(2, "林冲", "豹子头");
        doubleLinkedList.update(newNode);
        System.out.println("修改后的双向链表情况：");
        doubleLinkedList.show();

        //4、删除
        doubleLinkedList.delete(2);
        System.out.println("删除后的双向链表情况：");
        doubleLinkedList.show();

        //5、按顺序添加节点
        DoubleListNode newNode1 = new DoubleListNode(5, "林冲", "豹子头");
        doubleLinkedList.addByOrder(newNode1);
        System.out.println("按顺序添加节点后的双向链表情况：");
        doubleLinkedList.show();
    }
}
