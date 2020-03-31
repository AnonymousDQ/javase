package algorithm.linkedlist;

import java.util.Stack;

/**
 * @Description:定义一个SingleLinkedList来管理我们的英雄
 * @Author: VictorDan
 * @Date: 20-3-29 下午4:42
 * @Version: 1.0
 */
public class SingleLinkedList {
    /**
     * 先初始化一个头结点，头结点不要动，不存放具体的数据
     */
    private Node head = new Node(0, "", "");

    /**
     * 返回头结点
     *
     * @return
     */
    public Node getHead() {
        return head;
    }

    /**
     * 添加节点到单链表
     * 思路：当不考虑编号顺序的时候
     * 1、先找到当前链表的最后节点
     * 2、将最后这个节点的next指向新的节点
     *
     * @param newNode
     */
    public void add(Node newNode) {
        /**
         * 因为head节点不能动，因此需要一个辅助变量temp
         */
        Node temp = head;
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
         * 将最后这个节点的next指向新的节点
         */
        temp.next = newNode;
    }

    /**
     * 显示链表【遍历】
     */
    public void show() {
        /**
         * 先判断链表是否为空
         */
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            /**
             * 因为头结点不能动，因此需要一个辅助变量来遍历
             */
            Node temp = head.next;
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
     * 按照编号顺序来添加节点
     * 1、首先找到新添加的节点的位置，是通过temp辅助变量(指针),肯定通过变量搞定
     * 2、newNode.next=temp.next（新节点先连接temp.next防止断链）
     * 3、将temp.next=newNode(然后temp节点的next连到newNode)
     *
     * @param newNode
     */
    public void addByOrder(Node newNode) {
        /**
         * 思路：因为头节点head不能动，因此我们仍然通过一个辅助变量temp来帮助找到添加的位置
         * 因为是单链表，因此我们的temp是要移动到位于添加位置的前一个节点，否则插入不进去
         */
        Node temp = head;
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
            //插入到链表中，temp的后面
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    /**
     * 修改节点的信息，根据no编号来修改，也就是no编号不能改
     * 思路：
     * 1、根据newNode的no来修改就行
     *
     * @param newNode
     */
    public void update(Node newNode) {
        if (head.next == null) {
            System.out.println("链表为空！");
        } else {
            /**
             * 找到需要修改的节点，根据no编号来找
             * 1、先定义一个辅助变量temp
             */
            Node temp = head.next;
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
     * 从单链表删除一个节点
     * 思路：
     * 1、head节点不能动，还是需要一个临时变量temp，然后遍历先找到需要删除节点的前一个节点
     * 2、说明我们在比较时，temp.next.no和需要删除节点的no进行比较
     * 2、将temp节点的next指向temp.next.next；也就是temp.next=temp.next.next;
     * 3、此时被删除的节点(temp.next)没有任何引用指向它，在java中就成为一个垃圾，就会被垃圾回收机制回收
     */
    public void delete(int no) {
        Node temp = head;
        //标志是否找到待删除节点
        boolean flag = false;
        while (true) {
            //已经遍历到链表的最后
            if (temp.next == null) {
                break;
            } else if (temp.next.no == no) {
                //找到待删除的节点的前一个节点temp
                flag = true;
                break;
            } else {
                //temp后移，实现遍历
                temp = temp.next;
            }
        }
        if (flag) {
            //等号左边看成是temp节点的指针域，等号右边看成实际节点是temp的下一个节点的下一个
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }

    /**
     * 1、获取单链表的节点的个数(如果是带头节点的链表，不统计头结点)
     *
     * @param head 链表的头结点
     * @return 返回链表的有效节点的个数
     */
    public int getLength(Node head) {
        //空链表
        if (head.next == null) {
            return 0;
        } else {
            int length = 0;
            //定义一个辅助变量，这里我们没有统计头结点，因为cur已经指向第一个有效节点
            Node cur = head.next;
            while (cur != null) {
                length++;
                //遍历
                cur = cur.next;
            }
            return length;
        }
    }

    /**
     * 2、查找单链表中的倒数第k个节点
     * 思路：
     * 1、编写一个方法，接收head节点，同时接收一个index
     * 2、index表示是倒数第index个节点
     * 3、先把链表从头到尾遍历，得到链表总的长度getLength
     * 4、得到size后，我们从链表的第1个开始遍历，遍历size-index个节点，就可以得到
     * 5、如果找到则返回该节点，否则返回null
     */
    public Node findLastIndexNode(Node head, int index) {
        /**
         * 如果链表为空则返回null
         */
        if (head.next == null) {
            //没有找到
            return null;
        } else {
            /**
             * 第一次遍历得到链表的长度（节点个数）
             */
            int size = getLength(head);
            /**
             * 第二次遍历，size-index位置，就是我们倒数第k个节点
             * 思路：
             * 1、先校验index
             */
            if (index <= 0 || index > size) {
                return null;
            } else {
                /**
                 * 定义辅助变量cur，因为head节点不能动,
                 * 让cur指向第一个有效节点，for循环定位到倒数的index
                 */
                Node cur = head.next;
                for (int i = 0; i < size - index; i++) {
                    cur = cur.next;
                }
                return cur;
            }
        }
    }

    /**
     * 3、单链表的反转
     * 思路：
     * 1、先定义一个节点reverseHead=new Node();
     * 2、从头到尾遍历原来的链表，每遍历一个节点就将其取出，并放在新的链表的最前端。
     * 3、原来的链表的head.next=reverseHead.next;
     */
    public void reverseList(Node head) {
        //如果当前链表为空，或者只有1个节点，不需要反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        } else {
            /**
             * 1、先定义1个辅助变量cur，帮助我们遍历原来的链表
             */
            Node cur = head.next;
            /**
             * 2、指向当前节点的下一个节点
             * 因为我是用cur来操作将节点移动到新的reverHead，
             * 你如果直接操作，会导致链表断开了，所以我引入第二个变量，在将节点移动到新的头节点的时候
             * 先进行移动到当前节点cur的下一个节点，然后就不出断链
             */
            Node next = null;
            Node reverseHead = new Node(0, "", "");
            /**
             * 遍历原来的链表
             * 3、每次遍历一个节点，就将它取出，并放到新的链表reverserHead的最前端
             */
            while (cur != null) {
                //4、先暂时保存当前节点的下一个节点，因为后面需要使用
                next = cur.next;
                //5、将cur的下一个节点指向新的链表的最前端
                cur.next = reverseHead.next;
                //6、将cur连接到新的链表上
                reverseHead.next = cur;
                ///7、让cur后移（因为next已经后移到cur的下一个节点，所以最后移动cur直接等于next）
                cur = next;
            }
            //8、将head.next指向reverseHead.next，实现链表反转
            head.next = reverseHead.next;
        }
    }

    /**
     * leetcode解法
     * @param head
     * @return
     */
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head.next;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 4、单链表的从尾到头打印
     * 思路：
     * 1、逆序打印单链表
     * 方法1：先将单链表进行反转操作，然后再遍历，这样做的问题是，会破坏原来的单链表的结构，不建议
     * 方法2：可以利用stack数据结构，将各个节点压入到栈，利用stack先进后出的特点，实现逆序打印
     */
    public void reverseShow(Node head) {
        if (head.next == null) {
            //空链表，无法打印
            return;
        } else {
            //创建一个stack，将各个节点压入栈
            Stack<Node> stack = new Stack<>();
            Node cur = head.next;
            //将链表的所有节点压入栈
            while (cur != null) {
                stack.push(cur);
                //cur后移，这样就可以压入下一个节点
                cur = cur.next;
            }
            //将stack中的节点打印，pop出栈
            while (stack.size() > 0) {
                Node pop = stack.pop();
                //stack的特点是先进后出
                System.out.println(pop);
            }
        }
    }

    /**
     * 5、合并两个有序单链表，合并之后的链表依然有序
     * 思路：
     * 1、先创建一个新的节点，然后插入节点的时候判断两个链表的值，小的进行插入
     */

    public Node mergeTwoList(Node head1, Node head2) {
        Node newHead = new Node(0, "", "");
        //保留新链表的头结点
        Node temp = newHead;
        while (head1.next != null && head2.next != null) {
            /**
             * 比较两个链表的no值，将数据小的存入新的链表
             */
            if (head1.next.no < head2.next.no) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            //将新链表的临时节点后移
            temp = temp.next;
        }
        if (head1.next != null) {
            temp.next = head1;
        } else if (head2.next != null) {
            temp.next = head2;
        }
        return newHead.next;
    }

    /**
     * leetcode递归解法
     * @param l1
     * @param l2
     * @return
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.no < l2.no) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
