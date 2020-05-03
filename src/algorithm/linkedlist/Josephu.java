package algorithm.linkedlist;

/**
 * @Description: 约瑟夫环形链表问题
 * 1、构建一个单向的环形链表的思路
 * - 先创建第一个节点，让first指向该节点，节点不能动也就是head头结点，然后形成环形
 * - 后面每创建一个新的节点，就把该节点，加入大已有的环形链表
 * 2、遍历环形链表
 * - 先让一个辅助指针current，指向first节点，first节点还是不能动
 * - 然后通过一个while循环遍历环形链表，当current.next==first就结束
 * 3、约瑟夫问题-创建环形链表的思路
 * @Author: VictorDan
 * @Date: 20-5-3 下午3:38
 * @Version: 1.0
 */
public class Josephu {
    public static void main(String[] args) {
        //测试构建环形链表，遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.showBoy();
        //测试小孩出圈
        circleSingleLinkedList.countBoy(5,12,25);
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，构建形成一个环形的链表
    public void addBoy(int nums) {
        //nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
        } else {
            //辅助指针，帮助构建环形链表
            Boy current = null;
            //使用for来创建我们的环形链表
            for (int i = 1; i <= nums; i++) {
                //根据编号，创建小孩节点
                Boy boy = new Boy(i);
                //如果是第一个小孩
                if (i == 1) {
                    first = boy;
                    //构成环
                    first.setNext(first);
                    //让current指向第一个小孩
                    current = first;
                } else {
                    //让current的next指向下一个boy节点
                    current.setNext(boy);
                    //让boy的next指向first，构成环
                    boy.setNext(first);
                    //移动current指针到下一个
                    current = boy;
                }
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy(){
        if(first==null){
            System.out.println("没有任何小孩");
        }else{
            //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
            Boy current=first;
            while(true){
                System.out.printf("小孩的编号%d\n",current.getNo());
                //如果当前节点指向头结点，说明已经到最后，则跳出循环
                if(current.getNext()==first){
                    break;
                }else{
                    //让current后移
                    current=current.getNext();
                }
            }
        }
    }

    /**
     * 根据用户输入，计算出小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始报数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        //先对数据进行校验
        if(first==null||startNo<1||startNo>nums){
            System.out.println("参数输入有误");
        }else{
            //创建一个辅助指针，帮助完成小孩出圈
            Boy current=first;
            //需要创建一个辅助变量，先应该指向环形链表的最后这个节点
            while(true){
                //说明已经指向最后一个节点
                if(current.getNext()==first){
                    break;
                }else{
                    current=current.getNext();
                }
            }

            //1、从第k个小孩开始报数，所以先让first和current先移动到startNo-1次，移动到第startNo个节点
            for (int i = 0; i <startNo-1 ; i++) {
                first=first.getNext();
                current=current.getNext();
            }
            //2、当第k个小孩报数时，先让first和current指针同时移动countNum-1,然后出圈
            //这是一个循环操作，直到圈中只有一个节点
            while (true){
                //说明圈中只有一个节点
                if(current==first){
                    break;
                }else{
                    //让first和current指针同时移动countNum-1
                    for (int i = 0; i < countNum-1; i++) {
                        first=first.getNext();
                        current=current.getNext();
                    }
                    //此时first指向的节点，就是要出圈的小孩节点
                    System.out.printf("小孩%d出圈\n",first.getNo());
                    //这是将first指向的小孩节点出圈,需要出圈的节点，因为没有引用会被jvm的gc垃圾回收
                    first=first.getNext();
                    //然后让当前current节点的next指向新的first位置
                    current.setNext(first);
                }
            }
            //当while循环结束的时候，说明只剩下1个节点，然后此时current和first指向同一个位置
            System.out.printf("最后留在圈中的小孩编号%d\n",first.getNo());
        }
    }
}

//创建一个Boy类，表示节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
