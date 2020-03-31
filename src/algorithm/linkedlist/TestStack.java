package algorithm.linkedlist;

import java.util.Stack;

/**
 * @Description:演示栈的基本使用
 * @Author: VictorDan
 * @Date: 20-3-29 下午10:43
 * @Version: 1.0
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        /**
         * 出栈
         * smith,tom,jackqw
         */
        while(stack.size()>0){
            //pop是将栈顶的数据取出
            String pop = stack.pop();
            System.out.println(pop);
        }
    }
}
