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
        //singleLinkedList.show();

        /**
         * 3、测试修改节点的代码
         */
        Node newNode = new Node(2, "林冲", "豹子头");
        singleLinkedList.update(newNode);
        System.out.println("修改链表后的结果显示：");
        //singleLinkedList.show();

        /**
         * 4、删除一个节点
         */
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(4);
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
//        System.out.println("删除后的链表情况：");
//        singleLinkedList.show();

//        /**
//         * 5、求单链表中有效节点的个数
//         */
//        Node head = singleLinkedList.getHead();
//        int length = singleLinkedList.getLength(head);
//        System.out.printf("单链表中有效节点的个数为：%d\n", length);

//        /**
//         * 6、求单链表中倒数第index个节点
//         */
//        Node lastIndexNode = singleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 3);
//        System.out.println(lastIndexNode);

        /**
         * 7、反转链表
         */
//        System.out.println("原来链表的顺序为：");
//        singleLinkedList.show();
//        singleLinkedList.reverseList(singleLinkedList.getHead());
//        System.out.println("反转后的链表为：");
//        singleLinkedList.show();

        /**
         * 8、逆序打印链表，没有改变链表的本身顺序
         */
//        System.out.println("链表的逆序打印：");
//        singleLinkedList.reverseShow(singleLinkedList.getHead());


        SingleLinkedList head1=new SingleLinkedList();
        Node head1Node1 = new Node(1, "武松", "武松");
        Node head1Node2 = new Node(3, "华容", "华容");
        Node head1Node3 = new Node(5, "关羽", "关羽");
        Node head1Node4 = new Node(6, "张飞", "张飞");
        head1.add(head1Node1);
        head1.add(head1Node2);
        head1.add(head1Node3);
        head1.add(head1Node4);
        //head1.show();
//        System.out.println("合并之后的链表结果为：");
//        Node mergeTwoList = singleLinkedList.mergeTwoList(singleLinkedList.getHead(), head1.getHead());
//        while(mergeTwoList.next!=null){
//            System.out.println(mergeTwoList);
//            mergeTwoList=mergeTwoList.next;
//        }
        System.out.println("singleLinkeList打印结果为：");
        singleLinkedList.show();
        System.out.println("head1打印结果为：");
        head1.show();
        Node node = SingleLinkedList.mergeTwoLists(singleLinkedList.getHead(), head1.getHead());
        System.out.println("合并之后的链表结果为：");
        while(node.next!=null){
            System.out.println(node);
            node=node.next;
        }
    }

}
