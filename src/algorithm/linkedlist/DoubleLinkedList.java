package algorithm.linkedlist;

/**
 * @Description:创建双向链表
 * @Author: VictorDan
 * @Date: 20-3-30 下午6:48
 * @Version: 1.0
 */
public class DoubleLinkedList {
    /**
     * 先初始化一个头结点，头结点不要动，不存放具体的数据
     */
    private DoubleListNode head = new DoubleListNode(0, "", "");

    /**
     * 返回头结点
     *
     * @return
     */
    public DoubleListNode getHead() {
        return head;
    }

    /**
     * 双向链表【遍历】
     */
    public void show() {
        /**
         * 先判断链表是否为空
         */
        if (head.next == null) {
            System.out.println("双向链表为空！");
        } else {
            /**
             * 因为头结点不能动，因此需要一个辅助变量来遍历
             */
            DoubleListNode temp = head.next;
            while (true) {
                /**
                 * 判断是否链表到最后
                 */
                if (temp == null) {
                    break;
                } else {
                    /**
                     * 输出节点信息
                     * 因为已经重写了toString方法，所以可以直接输出节点信息就行
                     */
                    System.out.println(temp);
                    /**
                     * 将temp后移，一定小心，不然死循环。
                     */
                    temp = temp.next;
                }
            }
        }
    }

    /**
     * 双向链表的添加
     *
     * @param newNode
     */
    public void add(DoubleListNode newNode) {
        /**
         * 因为head节点不能动，因此需要一个辅助变量temp
         */
        DoubleListNode temp = head;
        /**
         * 遍历链表，找到最后一个节点，也就是next为null为最后的节点
         */
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            } else {
                //如果没有找到最后，就将temp后移
                temp = temp.next;
            }
        }
        /**
         * 当退出while循环时，temp就指向了链表最后
         * 将最后这个节点的next指向新的节点,形成双向链表
         */
        temp.next = newNode;
        newNode.pre = temp;
    }

    /**
     * 双向链表的修改
     * 可以看到双向链表修改一个节点的内容和单链表的修改一样
     * 只是节点的类型改成DoubleListNode
     *
     * @param newNode
     */
    public void update(DoubleListNode newNode) {
        if (head.next == null) {
            System.out.println("双向链表为空！");
        } else {
            /**
             * 找到需要修改的节点，根据no编号来找
             * 1、先定义一个辅助变量temp
             */
            DoubleListNode temp = head.next;
            //表示是否找到该节点
            boolean flag = false;
            while (true) {
                /**
                 * 如果temp为null，说明已经到链表最后，表示已经遍历完链表
                 */
                if (temp == null) {
                    break;
                } else if (temp.no == newNode.no) {
                    //找到要修改节点
                    flag = true;
                    break;
                } else {
                    temp = temp.next;
                }
            }
            //根据flag判断是否找到要修改的节点
            if (flag) {
                temp.name = newNode.name;
                temp.nickName = newNode.nickName;
            } else {
                System.out.printf("没有找到编号为%d的节点\n", newNode.no);
            }
        }
    }

    /**
     * 双向链表删除一个节点
     * 1、对于双向链表，我们可以直接找到要删除的这个节点
     * 2、找到以后，自我删除就行
     *
     * @param no
     */
    public void delete(int no) {
        /**
         * 判断当前链表是否为空
         */
        if (head.next == null) {
            System.out.println("双向链表为空，无法删除！");
        } else {
            //辅助变量
            DoubleListNode temp = head.next;
            //标志是否找到待删除节点
            boolean flag = false;
            while (true) {
                //已经遍历到链表的最后
                if (temp == null) {
                    break;
                } else if (temp.no == no) {
                    //找到待删除的节点的前一个节点temp
                    flag = true;
                    break;
                } else {
                    //temp后移，实现遍历
                    temp = temp.next;
                }
            }
            if (flag) {
                //temp.next=temp.next.next;[单向链表]
                /**
                 * temp.pre.next看成成temp.pre的节点，
                 * 也就是temp的前一个节点的next域指向temp.next节点
                 * 也就是指向temp的下一个节点
                 * 等号左边看成指针域，等号看成指向，等号右边看成指向实际的节点
                 */

                temp.pre.next = temp.next;
                //如果是最后一个节点，就不需要执行下面这句话，否则就出现空指针
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.printf("要删除的%d节点不存在\n", no);
            }
        }
    }

    /**
     * 双链表按照顺序添加节点
     *
     * @param newNode
     */
    public void addByOrder(DoubleListNode newNode) {
        /**
         * 思路：因为头节点head不能动，因此我们仍然通过一个辅助变量temp来帮助找到添加的位置
         * 因此我们的temp是要移动到位于添加位置的前一个节点，否则插入不进去
         */
        DoubleListNode temp = head;
        /**
         * 标志添加的编号是否存在，默认为false，如果存在则报提示信息
         */
        boolean flag = false;
        while (true) {
            //说明temp已经在链表最后
            if (temp.next == null) {
                break;
            }
            /**
             * 位置找到，就在temp的后面插入，temp.next是下一个节点，
             * 说明newNode就应该插在temp与temp.next之间
             */
            else if (temp.next.no > newNode.no) {
                break;
            }
            //说明希望添加的newNode的编号已经存在
            else if (temp.next.no == newNode.no) {
                //编号存在
                flag = true;
                break;
            } else {
                //后移，遍历链表来继续判断
                temp = temp.next;
            }
        }

        /**
         * 判断flag的值
         * flag=true不能添加说明编号存在
         */
        if (flag) {
            System.out.printf("准备插入的节点的编号%d已经存在，不能加入\n", newNode.no);
        } else {
            //将newNode插在temp节点和temp.next节点之间
            //1、首先防止断链，先把newNode的next域指向temp.next节点
            newNode.next = temp.next;
            //2、然后把newNode的pre指向temp
            newNode.pre = temp;
            //3、最后把temp的next域指向newNode
            temp.next = newNode;
        }
    }

}
